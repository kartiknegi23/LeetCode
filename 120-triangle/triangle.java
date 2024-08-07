class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[m][n];

        for(int i=0;i<n;i++){
            dp[m-1][i] = triangle.get(m-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];

                int next = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down, next);
            }
        }
         
        return dp[0][0];
    }
}