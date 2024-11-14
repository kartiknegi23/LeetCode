class Solution {
    public int findSub(int[][] matrix, int i, int j, int[][] dp){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]==0 )
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        int right = findSub(matrix, i, j+1, dp);
        int down = findSub(matrix, i+1, j, dp);
        int diagonal = findSub(matrix, i+1, j+1, dp);

        return dp[i][j] = 1+Math.min(right, Math.min(down, diagonal));
    }

    public int countSquares(int[][] matrix) {
        int count = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1)
                count += findSub(matrix, i, j, dp);
            }
        }

        return count;
    }
}