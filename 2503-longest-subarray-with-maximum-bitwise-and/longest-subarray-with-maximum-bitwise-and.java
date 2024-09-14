class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        int length = 0;
        int max_length = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max)
            length++;

            else
            length=0;

            max_length = Math.max(max_length, length);
        }

        return max_length;
    }
}