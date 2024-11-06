class Solution {
    public boolean canSortArray(int[] nums) {
        int[] arr = new int[nums.length];    
        for(int i=0;i<nums.length;i++){
            StringBuilder str = new StringBuilder();
            int num = nums[i];
            int count = 0;
            while(num>0){
                int rem = num%2;
                if(rem==1)
                count++;
                str.append(rem);
                num=num/2;
            } 
            arr[i] = count;
        }              

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1] && arr[j]==arr[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        if(Arrays.equals(copy, nums))
        return true;

        return false;
    }
}