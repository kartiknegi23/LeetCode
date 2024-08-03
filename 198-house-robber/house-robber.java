class Solution {

    public int rob(int[] nums) {
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1)
            take+=prev2;

            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}