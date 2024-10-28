class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer>hashmap = new HashMap<>();
        int result = 1;

        for(int i=0;i<nums.length;i++){
            int root = (int)Math.sqrt(nums[i]);
            if(root*root == nums[i]){
                if(hashmap.containsKey(root)){
                    hashmap.put(nums[i], hashmap.get(root)+1);
                    result = Math.max(result, hashmap.get(nums[i]));
                }

                else{
                    hashmap.put(nums[i], 1);
                }
            }
            else
            hashmap.put(nums[i], 1);
        }
        return result == 1 ? -1 : result;
    }
}