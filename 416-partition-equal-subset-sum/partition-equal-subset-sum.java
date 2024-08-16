class Solution {

    public int find(int[] nums, int index, int target1, int sum, int[][] dp){
        if(index>=nums.length){
            if(target1==sum/2)
            return 1;

            else
            return 0;
        }

        if(target1 > sum/2)
        return 0;

        if(dp[index][target1]!=-1)
        return dp[index][target1];

        int take = find(nums, index+1, target1+nums[index], sum, dp);

        int skip = find(nums, index+1, target1, sum, dp);

        int result = take | skip;

        return dp[index][target1] = result;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2!=0)
        return false;

        int[][] dp = new int[nums.length][sum/2+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int result = find(nums, 0, 0, sum, dp);

        return result==1 ? true : false;
    }
}