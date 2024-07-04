class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int count = 0;
        int low = 0;
        int high = 0;
        int i=0;
        while(high<nums.length){
            if(nums[high]==0){
                i++;
            }

            while(i>k){
                if(nums[low]==0){
                    i--;
                }
                low++;
            }

            result = Math.max(result, high-low+1);
            high++;
        }

        return result;
    }
}