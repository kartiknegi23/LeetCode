class Solution {
    public int solve(int index, int[] prices, int buy, int count, int[][][] dp){
        if(index>=prices.length)
        return 0;

        if(dp[index][buy][count]!=-1)
        return dp[index][buy][count];

        int profit = 0;
        //can buy//
        if(buy==1 && count<2){
            profit = Math.max(-prices[index]+solve(index+1, prices, 0, count+1, dp), 0+solve(index+1, prices,1,count, dp));
        }
        else if(buy==0){
            profit = Math.max(prices[index]+solve(index+1, prices, 1, count, dp), 0+solve(index+1,prices,0,count, dp));
        }

        return dp[index][buy][count] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        
        for(int j=0;j<2;j++){
            for(int k=0;k<3;k++){
                dp[prices.length][j][k]=0;
            }
        }

        for(int index=prices.length-1;index>=0;index--){
            for(int buy=1;buy>=0;buy--){
                for(int count=2;count>=0;count--){
                    int profit = 0;
                    //can buy//
                    if(buy==1 && count<2){
                        profit = Math.max(-prices[index]+dp[index+1][0][count+1], 0+dp[index+1][1][count]);
                    }
                    else if(buy==0){
                        profit = Math.max(prices[index]+dp[index+1][1][count], 0+dp[index+1][0][count]);
                    }

                    dp[index][buy][count] = profit;
                }
            }
        }
        

        return dp[0][1][0];
    }
}