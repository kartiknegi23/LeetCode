class Solution {
    public int solve(int index, int[] prices, int buy, int fee, int[][] dp){
        if(index>=prices.length)
        return 0;

        if(dp[index][buy]!=-1)
        return dp[index][buy];

        int profit = 0;
        //can buy//
        if(buy==1){
            profit = Math.max(-prices[index]+solve(index+1,prices,0,fee, dp), solve(index+1,prices,1,fee, dp));
        }
        else{
            profit = Math.max(prices[index]-fee+solve(index+1,prices,1,fee, dp), solve(index+1,prices,0,fee, dp));
        }
        return dp[index][buy] = profit;
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        for(int index=prices.length-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                int profit = 0;
                //can buy//
                if(buy==1){
                    profit = Math.max(-prices[index]+dp[index+1][0], dp[index+1][1]);
                }
                else{
                    profit = Math.max(prices[index]-fee+dp[index+1][1], dp[index+1][0]);
                }
                dp[index][buy] = profit;
            }
        }


        return dp[0][1];    
    }
}