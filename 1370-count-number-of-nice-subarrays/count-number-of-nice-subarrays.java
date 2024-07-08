class Solution {

    public int calc_sub(int[] nums, int k){
        if(k<0)
        return 0;

        int odd_count = 0;
        int high = 0;
        int low = 0;
        int result=0;

        while(high<nums.length){
            if(nums[high]%2==1)
            odd_count++;

            while(odd_count>k){
                if(nums[low]%2==1)
                odd_count--;

                low++;
            }

            result = result + (high-low+1);

            high++;
        }

        return result;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return calc_sub(nums, k) - calc_sub(nums, k-1);
    }
}