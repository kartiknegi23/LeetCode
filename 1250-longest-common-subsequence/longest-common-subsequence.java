class Solution {
    public int solve(int i, int j, String text1, String text2, int[][] dp){
        if(i==0 || j==0)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(text1.charAt(i-1)==text2.charAt(j-1)){
            return 1 + solve(i-1, j-1, text1, text2, dp);
        }

        //first//
        int first = solve(i-1, j, text1, text2, dp);

        //second//
        int second = solve(i, j-1, text1, text2, dp);

        return dp[i][j] = Math.max(first, second);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for(int i=0;i<=text1.length();i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=text2.length();j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }


                    else{
                        //first//
                        int first = dp[i-1][j];

                        //second//
                        int second = dp[i][j-1];

                        dp[i][j] = Math.max(first, second);
                    }
                    
                    
                }
            }

            return dp[text1.length()][text2.length()];
    }
}