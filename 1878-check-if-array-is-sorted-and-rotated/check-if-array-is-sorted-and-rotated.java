class Solution {
    public boolean check(int[] nums) {
        int rotation_point = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i])
            rotation_point++;
        }

        if(rotation_point>1)
        return false;

        if(rotation_point == 1){
            if(nums[nums.length-1] > nums[0])
            return false;

            else
            return true;
        }

        return true;
    }
}