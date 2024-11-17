class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int sum = 0;

        int left = 0;
        int right = 0;

        while(right<nums.length){
            sum+=nums[right];

            while(sum>=target && left<=right){
                length = Math.min(length, right-left+1);
                sum-=nums[left];
                left++;
            }

            right++;
        }

        return length==Integer.MAX_VALUE ? 0 : length;
    }
}