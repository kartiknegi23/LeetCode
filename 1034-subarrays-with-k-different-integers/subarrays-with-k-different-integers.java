class Solution {
    public int calc_sub(int[] nums, int k){
        int high=0;
        int low=0;
        int count=0;
        if(k<=0)
        return 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        while(high<nums.length){
            hashmap.put(nums[high], hashmap.getOrDefault(nums[high], 0)+1);
            while(hashmap.size()>k){
                hashmap.put(nums[low], hashmap.get(nums[low])-1);
                if(hashmap.get(nums[low])==0)
                hashmap.remove(nums[low]);
                low++;
            }
            count+=(high-low+1);
            high++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return calc_sub(nums,k) - calc_sub(nums, k-1);
        
    }
}