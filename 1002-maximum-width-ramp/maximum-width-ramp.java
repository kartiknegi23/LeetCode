class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] right_max = new int[nums.length];
        right_max[right_max.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            right_max[i] = Math.max(nums[i], right_max[i+1]);
        }
        int result = 0;
        int i=0;
        int j=0;
        while(i<nums.length && j<right_max.length){
            while((j<right_max.length) && (right_max[j]>=nums[i])){
                result = Math.max(result, j-i);
                j++;
            }
            i++;
        }

        return result;
    }
}