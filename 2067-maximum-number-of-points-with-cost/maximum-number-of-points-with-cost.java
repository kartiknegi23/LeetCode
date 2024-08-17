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

            left[0]=dp[0];
            for(int i=1;i<n;i++){
                left[i] = Math.max(dp[i], left[i-1]-1);
            }

            right[n-1] = dp[n-1];
            for(int i=n-2;i>=0;i--){
                right[i] = Math.max(dp[i], right[i+1]-1);
            }

            for(int i=0;i<n;i++){
                curr[i] = points[row][i] + Math.max(left[i], right[i]);
            }

            dp = curr;
        }

        for(int j=0;j<n;j++){
            maxi = Math.max(maxi, dp[j]);
        }

        return maxi;
    }
}