class Solution {

    public int calculate(int count, int clipboard, int n, int[][] dp){
        if(count==n)
        return 0;

        if(count>n)
        return 1000000;

        if(dp[count][clipboard]!=-1)
        return dp[count][clipboard];

        //Paste//
        int paste = 1 + calculate(count+clipboard, clipboard, n, dp);

        //Copy & Paste//
        int copy_paste = 1 + 1 + calculate(count*2, count, n, dp);

        return dp[count][clipboard] = Math.min(paste, copy_paste);
    }

    public int minSteps(int n) {
        if(n==1)
        return 0;

        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return 1 + calculate(1, 1, n, dp);
    }
}