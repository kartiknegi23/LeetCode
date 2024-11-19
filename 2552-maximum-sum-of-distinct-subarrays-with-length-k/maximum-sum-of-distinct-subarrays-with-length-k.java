class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if(k>nums.length)
        return 0;

        Set<Integer>hashset = new HashSet<>();
        
        int left = 0;
        int right = 0;
        long sum=0;
        long ans = Long.MIN_VALUE;

        while(right<nums.length){
            sum+=nums[right];
            while((left<=right && hashset.contains(nums[right]) || (right-left+1>k))){
                sum-=nums[left];
                hashset.remove(nums[left]);
                left++;
            }
            hashset.add(nums[right]);
            if(right-left+1==k)
            ans = Math.max(ans, sum);

            right++;
        }

        return ans==Long.MIN_VALUE? 0 : ans;
    }
}