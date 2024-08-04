class Solution {
    public int calc(int[] nums, int index, int start, int[] dp){
        if(index==start)
        return nums[index];

        if(index<start)
        return 0;

        if(dp[index]!=-1)
        return dp[index];

        //Take//
        int take = nums[index] + calc(nums, index-2, start, dp);

        //Skip//
        int skip = calc(nums, index-1, start, dp);

        return dp[index] = Math.max(take, skip);
    }


    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];

        if(nums.length==2)
        return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int first = calc(nums, nums.length-2, 0, dp);

        Arrays.fill(dp, -1);

        int last = calc(nums, nums.length-1, 1, dp);

        System.out.println(first);
        System.out.println(last);

        return Math.max(first, last);
    }
}