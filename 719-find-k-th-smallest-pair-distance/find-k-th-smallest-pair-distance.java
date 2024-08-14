class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        int maxi = Arrays.stream(nums).max().orElseThrow();
        int[] arr = new int[maxi+1];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int diff = Math.abs(nums[i]-nums[j]);
                arr[diff]++;
            }
        }

        for(int i=0;i<arr.length;i++){
            k-=arr[i];
            if(k<=0)
            return i;
        }
        
        return -1;
    }
}