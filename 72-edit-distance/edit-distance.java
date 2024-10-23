class Solution {
    public int solve(int i, int j, String word1, String word2, int[][] dp){
        if(i==0)
        return j;

        if(j==0)
        return i;

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(word1.charAt(i-1) == word2.charAt(j-1))
        return  dp[i][j] = 0 + solve(i-1, j-1, word1, word2, dp);

        return dp[i][j] = Math.min(1+solve(i, j-1, word1, word2, dp), Math.min(1+solve(i-1, j, word1, word2, dp), 1+solve(i-1, j-1, word1, word2, dp)));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(word1.length(), word2.length(), word1, word2, dp);
    }
}