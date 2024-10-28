class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int result = 0; 
        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(nums[i]-1)){
                hashmap.put(nums[i], hashmap.get(nums[i]-1)+1);
            }
            else{
                hashmap.put(nums[i], 1);
            }
            result = Math.max(result, hashmap.get(nums[i]));
        }

        return result;
    }
}