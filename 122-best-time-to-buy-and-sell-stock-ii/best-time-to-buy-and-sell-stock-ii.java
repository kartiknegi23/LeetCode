class Solution {
    public int solve(int index, int[] prices, int buy, int[][] dp){
        if(index>=prices.length)
        return 0;

        if(dp[index][buy]!=-1)
        return dp[index][buy];

        int profit = 0;
        if(buy==1){
            //we buy or not buy//
            profit = Math.max(-prices[index]+solve(index+1, prices, 0, dp), 0+solve(index+1, prices, 1, dp));
        }

        else{
            profit = Math.max(prices[index]+solve(index+1, prices, 1, dp), 0+solve(index+1,prices, 0, dp));
        }

        return dp[index][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, prices, 1, dp);
    }
}