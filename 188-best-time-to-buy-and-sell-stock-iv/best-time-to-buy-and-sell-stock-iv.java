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
        int[][][] dp = new int[prices.length+1][2][k+1];


        for(int i=0;i<2;i++){
            for(int j=0;j<=k;j++){
                dp[prices.length][i][j] = 0;
            }
        }

        for(int index=prices.length-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                for(int cap=0;cap<=k;cap++){
                    int profit = 0;
                    //can buy//
                    if(buy==1 && cap>0){
                        profit = Math.max(-prices[index]+dp[index+1][0][cap-1], dp[index+1][1][cap]);
                    }

                    //can sell//
                    else if(buy==0){
                        profit = Math.max(prices[index]+dp[index+1][1][cap], dp[index+1][0][cap]);
                    }

                    dp[index][buy][cap] = profit;
                }
            }
        }


        return dp[0][1][k];
    }
}