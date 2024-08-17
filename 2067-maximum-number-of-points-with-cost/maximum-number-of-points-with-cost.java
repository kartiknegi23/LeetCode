class Solution {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[m-1].length;
        long maxi = Integer.MIN_VALUE;

        long[] dp = new long[n];
        
        for(int j=0;j<n;j++){
            dp[j] = points[0][j];
        }

        for(int row=1;row<m;row++){
            long[] left = new long[n];
            long[] right = new long[n];
            long[] curr = new long[n];

            // Left sweep
            left[0] = dp[0];
            for (int col = 1; col < n; col++) {
                left[col] = Math.max(left[col - 1] - 1, dp[col]);
            }

            // Right sweep
            right[n - 1] = dp[n - 1];
            for (int col = n - 2; col >= 0; col--) {
                right[col] = Math.max(right[col + 1] - 1, dp[col]);
            }

            // Calculate current row dp values
            for (int col = 0; col < n; col++) {
                curr[col] = points[row][col] + Math.max(left[col], right[col]);
            }

            dp = curr;
        }

        for(int j=0;j<n;j++){
            maxi = Math.max(maxi, dp[j]);
        }

        return maxi;
    }
}