class Solution {
    public long continuousSubarrays(int[] nums) {
        long count = 0;
        int left = 0;
        int right = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while(right<nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            int min = map.firstKey();
            int max = map.lastKey();
            
            while(left<right && Math.abs(min-max)>2)
            {   
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
                min = map.firstKey();
                max = map.lastKey();
            }

            count+=(right-left+1);
            right++;
        }
        return count;
    }
}