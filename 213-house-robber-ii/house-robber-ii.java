class Solution {
    
    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];

        if(nums.length==2)
        return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        dp[0] = nums[0];

        for(int i=1;i<nums.length-1;i++){
            int take = nums[i];
            if(i>1)
            take+=dp[i-2];

            int skip = dp[i-1];

            dp[i] = Math.max(take, skip);
        }

        int first = dp[dp.length-2];

        Arrays.fill(dp, -1);
        dp[1] = nums[1];

        for(int i=2;i<nums.length;i++){
            int take = nums[i];
            if(i>2)
            take+=dp[i-2];

            int skip = dp[i-1];

            dp[i] = Math.max(take, skip);
        }

        int last = dp[dp.length-1];

        return Math.max(first, last);
    }
}