class Solution {
    public int solve(int index, int[] prices, int buy, int k, int[][][] dp){
        if(index>=prices.length)
        return 0;

        if(dp[index][buy][k]!=-1)
        return dp[index][buy][k];

        int profit = 0;
        //can buy//
        if(buy==1 && k>0){
            profit = Math.max(-prices[index]+solve(index+1,prices,0,k-1, dp), solve(index+1,prices,1,k, dp));
        }

        //can sell//
        else if(buy==0){
            profit = Math.max(prices[index]+solve(index+1,prices,1,k, dp), solve(index+1,prices,0,k, dp));
        }

        return dp[index][buy][k] = profit;
    }

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, prices, 1, k, dp);
    }
}