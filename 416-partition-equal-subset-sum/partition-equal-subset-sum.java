class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2!=0)
        return false;

        int[][] dp = new int[nums.length][sum/2+1];
        
        for(int i=0;i<nums.length;i++){
            dp[i][0] = 1;
        }

        if(nums[0]<=sum/2)
        dp[0][nums[0]]=1;

        for(int index=1;index<nums.length;index++){
            for(int target1=1;target1<=sum/2;target1++){
                
                int take = 0;
                if(target1>=nums[index])
                take = dp[index-1][target1-nums[index]];

                int skip = dp[index-1][target1];

                dp[index][target1] = take | skip;
            }
        }

        return dp[nums.length-1][sum/2]==1? true : false;
    }
}