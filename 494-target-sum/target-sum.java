class Solution {
    public int solve(int index, int current, int target, int[] nums, int[][] dp, int offset){
        if(index>=nums.length){
            if(current==target)
            return 1;

            else
            return 0;
        }

        if(dp[index][current+offset]!=-1)
        return dp[index][current+offset];

        //+//
        int plus = solve(index+1, current+nums[index], target, nums, dp, offset);

        //-//
        int minus = solve(index+1, current-nums[index], target, nums, dp, offset);

        return dp[index][current+offset] = plus+minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int offset = 0;
        for(int i : nums){
            offset+=i;
        }

        int[][] dp = new int[nums.length][(2*offset)+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, target, nums, dp, offset);
    }
}