class Solution {
    public boolean solve(int i , int j, String s, String p, int[][] dp){
        if(i==0 && j==0)
        return true;

        if(j==0)
        return false;

        if(i==0)
        {
            for(int k=0;k<j;k++){
            if(p.charAt(k)!='*')
            return false;  
            }
            return true;
        }

        if(dp[i][j]!=-1)
        return dp[i][j]==1 ? true : false;

        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='?'){
            dp[i][j] = solve(i-1, j-1, s, p, dp) == true ? 1 : 0 ;
            return dp[i][j] == 1 ? true : false;
        }

        else if(p.charAt(j-1) == '*'){
            dp[i][j] = ((solve(i, j-1, s, p, dp) || solve(i-1, j, s, p, dp))) == true ? 1 : 0 ;
            return dp[i][j] == 1 ? true : false;
        }

        dp[i][j] = 0;
        return dp[i][j] == 0 ? false : true;
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }

        return solve(s.length(), p.length(), s, p, dp);
    }
}