class Solution {
    public int min_path(List<List<Integer>> triangle, int i, int j, int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=-1)
        return dp[i][j];

        int down = Integer.MAX_VALUE;

        if(i<triangle.size()-1){
            down = triangle.get(i).get(j) + min_path(triangle, i+1, j, dp);
        }

        int next = triangle.get(i).get(j) + min_path(triangle, i+1, j+1, dp);

        return dp[i][j] = Math.min(down, next);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
         
        return min_path(triangle, 0, 0, dp);
    }
}