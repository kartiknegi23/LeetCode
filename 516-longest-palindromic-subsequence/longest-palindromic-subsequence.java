class Solution {
    public int solve(int i, int j, String s, String t, int[][] dp){
        if(i<0 || j<0)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
        return dp[i][j] = 1 + solve(i-1, j-1, s, t, dp);

        return dp[i][j] = Math.max(solve(i-1, j, s, t, dp), solve(i, j-1, s, t, dp));
    }

    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][t.length()];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(s.length()-1, t.length()-1, s, t, dp);
    }
}