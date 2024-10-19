class Solution {
    public int solve(int index, int current, int amount, int[] coins, int[][] dp){
        if(index>=coins.length){
            if(current==amount)
            return 1;

            else
            return 0;
        }

        if(current>amount)
        return 0;

        if(dp[index][current]!=-1)
        return dp[index][current];

        int skip = solve(index+1, current, amount, coins, dp);

        int take = solve(index, current+coins[index], amount, coins, dp);

        return dp[index][current] = skip+take;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, amount, coins, dp);
    }
}