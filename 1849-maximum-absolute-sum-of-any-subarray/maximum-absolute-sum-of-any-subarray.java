class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;

        int sum1 = 0;
        int sum2 = 0;

        for(int i=0;i<nums.length;i++){
            sum1+=nums[i];
            sum2+=nums[i];

            if(sum1>0){
                maxSum = Math.max(maxSum, sum1);
            }

            if(sum1<0)
            sum1=0;

            if(sum2<0){
                minSum = Math.min(minSum, sum2);
            }
            
            if(sum2>0)
            sum2=0;
            
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}