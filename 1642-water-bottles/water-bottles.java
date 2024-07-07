class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles<numExchange)
        return numBottles;

        int count = numBottles;
        int empty = numBottles;
        
        while((empty/numExchange)>0){
            numBottles = empty/numExchange;
            empty = empty%numExchange;
            count+=numBottles;
            empty += numBottles;
        }

        return count;
    }
}