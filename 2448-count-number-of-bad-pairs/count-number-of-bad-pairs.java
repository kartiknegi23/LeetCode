class Solution {
    public long countBadPairs(int[] nums) {
        long goodPair = 0;
        long n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long diff = i-nums[i];
            if(map.containsKey(diff)){
                long count = map.get(diff);
                goodPair+=count;
                map.put(diff, count+1);
            }
            else
            map.put(diff, 1L);
        }    
        return ((n*(n-1))/2) - goodPair;
    }
}