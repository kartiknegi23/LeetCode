class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int low = 0;
        int high = 0;
        int odd_count = 0;
        int count = 0;

        while(high<nums.length){
            if(nums[high]%2==1)
            {   
                count = 0;
                odd_count++;
            }

            while(odd_count==k){
                if(low<nums.length && nums[low]%2==1)
                odd_count--;

                low++;
                count++;
            }
            result+=count;
            high++;
        }
        return result; 
    }
}