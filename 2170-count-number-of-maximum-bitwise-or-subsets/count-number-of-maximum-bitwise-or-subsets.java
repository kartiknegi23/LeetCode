class Solution {
    public int solve(int index, int current, int[] nums, int target){
        if(index>=nums.length){
            if(current==target){
                return 1;
            }
            else
            return 0;
        }

        //take//
        int take = solve(index+1, current|nums[index], nums, target);

        //skip//
        int skip = solve(index+1, current, nums, target);

        return take + skip; 
    }

    public int countMaxOrSubsets(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor = xor | nums[i];
        }

        return solve(0, 0, nums, xor);
    }
}