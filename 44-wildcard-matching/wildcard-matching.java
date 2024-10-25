class Solution {

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];

        dp[0][0] = 1;
        for(int i=1;i<=s.length();i++){
            dp[i][0] = 0;
        }

        boolean flag = true;
        for(int j=1;j<=p.length();j++){
            for(int k=1;k<=j;k++){
                if(p.charAt(k-1)!='*')
                {
                    flag = false;
                    break;
                }
            }
            if(flag==true)
            dp[0][j] = 1;
        }

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1] ;
                }

                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = (dp[i][j-1] | dp[i-1][j]);
                }

                else
                dp[i][j] = 0;
            }
        }

        return dp[s.length()][p.length()] == 1 ? true : false;
    }
}