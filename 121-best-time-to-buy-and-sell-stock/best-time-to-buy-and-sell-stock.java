class Solution {
    public int maxProfit(int[] prices) {
        int minimum_price = prices[0];
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            int profit = prices[i] - minimum_price;
            if(profit>ans){
                ans = profit;
            } 

            if(minimum_price>prices[i])
            minimum_price = prices[i];
        }    
        return ans;
    }
}