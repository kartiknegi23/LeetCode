class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count1 = 0;
        int low = 0;
        int high = 0;
        int sum = 0;
        
        while(high<nums.length){  // In this loop we will calculate no of subarrays where sum<=target
            sum+=nums[high];

            while(sum>goal){
                sum-=nums[low];
                low++;
            }

            count1 = count1 + (high-low+1);
            high++;
        }
        
        if(goal==0)
        return count1;

        low=0;
        high=0;
        sum=0;
        int count2 = 0;
        int new_goal = goal-1;
        while(high<nums.length){
            sum+=nums[high];

            while(sum>new_goal){
                sum-=nums[low];
                low++;
            }

            count2 = count2 + (high-low+1);
            high++;
        }

        return count1-count2;
    }
}