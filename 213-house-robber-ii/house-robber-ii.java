class Solution {

    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];

        if(nums.length==2)
        return Math.max(nums[0], nums[1]);

        int prev1 = nums[0];
        int prev2 = 0; 

        for(int i=1;i<nums.length-1;i++){
            int take = nums[i];
            if(i>1)
            take+=prev2;

            int skip = prev1;

            int current = Math.max(take, skip);
            prev2 = prev1;
            prev1 = current;
        }

        int first = prev1;

        prev1 = nums[1];
        prev2 = 0;

        for(int i=2;i<nums.length;i++){
            int take = nums[i];
            if(i>2)
            take+=prev2;

            int skip = prev1;

            int current = Math.max(take, skip);
            prev2 = prev1;
            prev1 = current;
        }

        int last = prev1;

        return Math.max(first, last);
    }
}