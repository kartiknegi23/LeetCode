class Solution {
    public boolean isPossible(int mid, int[] nums, int maxOperations){
        int total_operations = 0;
        for(int i=0;i<nums.length;i++){
            int operation = nums[i]/mid;
            if(operation>0 && nums[i]%mid==0)
            operation--;
            total_operations+=operation;
        }
        
        if(total_operations>maxOperations)
        return false;

        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        
        int left = 1;
        int right = max;
        int result = 0;

        while(left<=right){
            int mid = (left+right)/2;

            if(isPossible(mid, nums, maxOperations)){
                result = mid;
                right=mid-1;
            }

            else
            left=mid+1;
        }

        return result;
    }
}