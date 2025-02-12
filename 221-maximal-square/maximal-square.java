class Solution {
    public int solve(int i, int j, char[][] matrix, int[][] dp){
        if(j>=matrix[0].length || i>=matrix.length || matrix[i][j]=='0')
        return 0;

        if(dp[i][j]!= -1)
        return dp[i][j];

        int right = 1 + solve(i, j+1, matrix, dp);
        int diagonal = 1 + solve(i+1, j+1, matrix, dp);
        int down = 1 + solve(i+1, j, matrix, dp);

        return dp[i][j] = Math.min(right, Math.min(diagonal, down));
    }

    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = (matrix[i][j] - '0');
                }

                else if(matrix[i][j]=='1'){
                    int left = 1 + dp[i][j-1];
                    int diagonal = 1 + dp[i-1][j-1];
                    int up = 1 + dp[i-1][j];

                    dp[i][j] = Math.min(left, Math.min(diagonal, up));
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans*ans;
    }
}