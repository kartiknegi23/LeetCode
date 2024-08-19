class Solution {
    public int minSteps(int n) {
        if(n==1)
        return 0;

        int[][] dp = new int[n+1][n+1];

        // Initialize the dp array with a large value, indicating unvisited states
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<=n;i++){
            dp[n][i]=0;
        }

        for(int count=n-1;count>=0;count--){
            for(int clipboard=n-1;clipboard>=0;clipboard--){

                int paste = Integer.MAX_VALUE;
                int copy_paste = Integer.MAX_VALUE;

                //Paste//
                if(count+clipboard<=n && dp[count+clipboard][clipboard]!=Integer.MAX_VALUE)
                paste = 1 + dp[count+clipboard][clipboard];

                //Copy & Paste//
                if(count*2<=n && dp[count*2][count]!=Integer.MAX_VALUE)
                copy_paste = 1 + 1 + dp[count*2][count];

                dp[count][clipboard] = Math.min(paste, copy_paste);
            }
        }

        return dp[1][0];
    }
}