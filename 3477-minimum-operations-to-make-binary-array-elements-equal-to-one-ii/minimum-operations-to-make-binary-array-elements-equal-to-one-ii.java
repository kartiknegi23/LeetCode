class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int flipstate = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==flipstate)
            {
                count++;
                flipstate = 1-flipstate;
            }
        }
        return count;
    }
}