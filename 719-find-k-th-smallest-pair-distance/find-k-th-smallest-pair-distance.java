class Solution {
    public int count_pairs(int[] nums, int target){
        int i=0;
        int j=1;
        int count = 0;

        while(j<nums.length){
            while(nums[j]-nums[i]>target)
            i++;

            count += (j-i);
            j++;
        }

        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length-1]-nums[0];

        int result = 0;
        while(l<=r){
            int mid = (l+r)/2;

            int pairs = count_pairs(nums, mid);

            if(pairs<k){
                l = mid+1;
            }
            else{
                result = mid;
                r = mid-1;
            }
        }

        return result;
    }
}