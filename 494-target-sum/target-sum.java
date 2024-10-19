class Solution {
    public int solve(int index, int current, int target, int[] nums){
        if(index>=nums.length){
            if(current==target)
            return 1;

            else
            return 0;
        }

        //+//
        int plus = solve(index+1, current+nums[index], target, nums);

        //-//
        int minus = solve(index+1, current-nums[index], target, nums);

        return plus+minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][];

        return solve(0, 0, target, nums);
    }
}