class Solution {
    public int solve(int index, int amount, int[] coins, int[][] dp){
        if(index==0){
            if(amount%coins[index]==0)
            return amount/coins[index];

            return (int)1e8;
        }

        if(dp[index][amount]!=-1)
        return dp[index][amount];

        //skip//
        int skip = 0 + solve(index-1, amount, coins, dp);

        int take = Integer.MAX_VALUE;

        if(coins[index]<=amount)
        take = 1 + solve(index, amount-coins[index], coins, dp);

        return dp[index][amount] = Math.min(skip, take);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(coins.length-1, amount, coins, dp);

        if(ans>=1e8)
        return -1;

        else
        return ans;
    }
}