class Solution {
    public int calc(int[] nums, int n, int[] dp){
        if(n==0)
        return nums[n];

        if(n<0)
        return 0;

        if(dp[n]!=-1)
        return dp[n];

        //take//
        int take = nums[n] + calc(nums, n-2, dp);

        //skip//
        int skip = calc(nums, n-1, dp);

        return dp[n] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);

        dp[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1)
            take+=dp[i-2];

            int skip = dp[i-1];

            dp[i] = Math.max(take, skip); 
        }

        return dp[nums.length-1];
    }
}