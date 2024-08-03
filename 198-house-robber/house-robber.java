class Solution {
    public int calc(int[] nums, int n, int[] dp){
        if(n>=nums.length)
        return 0;

        if(dp[n]!=-1)
        return dp[n];

        int right = Integer.MIN_VALUE; 
        
        int left = calc(nums, n+1, dp);

        right = calc(nums, n+2, dp) + nums[n];

        return dp[n] = Math.max(left, right);
    }

    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return calc(nums, 0, dp);        
    }
}