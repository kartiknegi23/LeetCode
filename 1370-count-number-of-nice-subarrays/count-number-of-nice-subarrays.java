class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int odd_count = 0;
        int count = 0;
        int low = 0;
        int high = 0;

        while(high<nums.length){
            if(nums[high]%2==1){
                odd_count++;
                count = 0;
            }

            while(odd_count==k){
                count++;
                if(nums[low]%2==1)
                odd_count--;

                low++;
            }
            result+=count;

            high++;
        }
        return result;
    }
}