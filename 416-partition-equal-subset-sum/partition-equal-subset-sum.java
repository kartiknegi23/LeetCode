class Solution {
    public int solve(int index, int[] nums, int current, int target, int[][] dp){
        if(current==target)
        return 1;

        if(current>target || index>=nums.length)
        return 0;
        
        if (dp[index][current]!=-1) {
            return dp[index][current]; // Already computed and is true
        }

        int take = solve(index+1, nums, current+nums[index], target, dp);

        int skip = solve(index+1, nums, current, target, dp);

        return dp[index][current] = take | skip;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }    
        
        if(sum%2!=0)
        return false;

        int target = sum/2;
        int current = 0;

        int[][] dp = new int[nums.length][target+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, nums, current, target, dp) == 1 ? true : false; 
    }
}