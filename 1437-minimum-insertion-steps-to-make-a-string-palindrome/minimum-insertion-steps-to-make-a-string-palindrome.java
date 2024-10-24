class Solution {
    public int minInsertions(String s) {
        StringBuilder t = new StringBuilder(s).reverse();
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i=0;i<=s.length();i++){
            dp[i][0] = 0;
        }

        for(int i=0;i<=s.length();i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }

                else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int len = dp[s.length()][t.length()];

        return s.length()-len;
    }
}