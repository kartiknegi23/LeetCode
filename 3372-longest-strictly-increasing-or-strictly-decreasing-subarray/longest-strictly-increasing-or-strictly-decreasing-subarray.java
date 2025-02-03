class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increase = 1;
        int decrease = 1;
        int result = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1])
            {
                increase++;
                decrease = 1;
            }

            else if(nums[i] < nums[i-1]){
                decrease++;
                increase = 1;
            }

            else{
                decrease = 1;
                increase = 1;
            }

            result = Math.max(result, Math.max(increase, decrease));
        }
        return result;
    }
}