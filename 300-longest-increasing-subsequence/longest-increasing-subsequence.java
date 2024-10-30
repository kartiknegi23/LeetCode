class Solution {
    public int solve(int index, int[] nums, int last, int[][] dp){
        if(index>=nums.length)
        return 0;

        if(dp[index][last+1]!=-1)
        return dp[index][last+1];

        int pick = 0;
        //pick//
        if(last==-1 || nums[index]>nums[last])
        pick = 1+solve(index+1,nums,index, dp);

        //skip//
        int skip = solve(index+1,nums,last, dp);

        return dp[index][last+1] = Math.max(pick, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, nums, -1, dp);
    }
}