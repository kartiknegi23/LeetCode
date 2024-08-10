class Solution {

    public int calculate(int[] nums, int sum, int index, int current, int[][] dp){
        if(index>=nums.length || current>sum/2)
        return 0;

        if(current==sum/2)
        return 1;

        if(dp[index][current]!=-1)
        return dp[index][current];

        //Take//
        int take = calculate(nums, sum, index+1, current+nums[index], dp);

        //Skip//
        int skip = calculate(nums, sum, index+1, current, dp);

        if(take==1 || skip==1)
        return dp[index][current] = 1;

        else
        return dp[index][current] = 0;
    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2!=0)
        return false;

        int[][] dp = new int[nums.length][sum+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return calculate(nums, sum, 0, 0, dp) == 1 ? true : false;
    }
}