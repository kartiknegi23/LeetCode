class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        if(n==1)
        return matrix[0][0];

        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = matrix[0][i];
        }

        for(int i=1;i<n;i++){
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            int[] current = new int[n];
            for(int j=0;j<n;j++){
                if(j>0)
                left = dp[j-1];

                int center = dp[j];

                if(j<n-1)
                right = dp[j+1];

                current[j] = matrix[i][j] + Math.min(left, Math.min(center, right));
            }
            dp = current;
        }

        int result = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            result = Math.min(result, dp[i]);
        }

        return result;
    }
}