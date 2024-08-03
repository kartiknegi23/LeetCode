class Solution {
    
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