class Solution {

    public int calculate(int[] nums) {
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

    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];

        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        int index1=0;
        int index2=0;

        for(int i=0;i<nums.length;i++){
            if(i!=0)
            {
                arr2[index2]=nums[i];
                index2++;
            }

            if(i!=nums.length-1){
                arr1[index1]=nums[i];
                index1++;
            }
        }

        return Math.max(calculate(arr1), calculate(arr2));

        
    }
}