class Solution {

    public int calculate_subarray(int[] nums, int goal){
        int count = 0;
        int low = 0;
        int high = 0;
        int sum = 0;

        if(goal<0)
        return 0;
        
        while(high<nums.length){
            sum+=nums[high];

            while(sum>goal){
                sum-=nums[low];
                low++;
            }

            count = count + (high-low+1);
            high++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return calculate_subarray(nums, goal)-calculate_subarray(nums, goal-1);
        
    }
}