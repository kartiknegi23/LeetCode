class Solution {

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        
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