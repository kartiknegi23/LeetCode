class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = (sum + nums[i])%p;
        }
        int target = sum%p;

        if(target==0)
        return 0;

        Map<Integer, Integer>hashmap = new HashMap<>();
        hashmap.put(0, -1);
        int result = nums.length;
        int curr = 0;

        for(int i=0;i<nums.length;i++){
            curr = (curr + nums[i])%p;

            int remain = (curr - target + p) % p;

            if(hashmap.containsKey(remain)){
                result = Math.min(result, i-hashmap.get(remain));
            }

            hashmap.put(curr, i);
             
        }

        return result==nums.length ? -1 : result;
    }
}