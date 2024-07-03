class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4)
        return 0;

        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;

        for(int i=0;i<=3;i++){
            result = Math.min(result, nums[nums.length-3+i-1]-nums[i]);
        }

        return result;
    }
}