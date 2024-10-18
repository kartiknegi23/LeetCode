class Solution {
    public int solve(int index, int current, int[] nums, int target, int[][] dp){
        if(index>=nums.length){
            if(current==target){
                return 1;
            }
            else
            return 0;
        }

        if(dp[index][current]!=-1)
        return dp[index][current];

        //take//
        int take = solve(index+1, current|nums[index], nums, target, dp);

        //skip//
        int skip = solve(index+1, current, nums, target, dp);

        return dp[index][current] = take + skip; 
    }

    public int countMaxOrSubsets(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor = xor | nums[i];
        }

        int[][] dp = new int[nums.length][xor+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, nums, xor, dp);
    }
}