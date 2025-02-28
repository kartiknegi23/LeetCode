class Solution {
    public int solve(String text1, String text2, int i, int j, int[][] dp){
        if(i<0 || j<0)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + solve(text1, text2, i-1, j-1, dp);
        }

        int left = solve(text1, text2, i-1, j, dp);

        int right = solve(text1, text2, i, j-1, dp);

        return dp[i][j] = Math.max(left, right);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(text1, text2, text1.length()-1, text2.length()-1, dp);
    }
}