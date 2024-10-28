class Solution {

    public int longestSquareStreak(int[] nums) {
        Set<Long>hashmap = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hashmap.add((long)nums[i]);
        }

        int result = 0;
        for(int i=0;i<nums.length;i++){
            long ele = nums[i];
            int count = 0;
            for(long num = ele; num<=100000; num = num*num){
                if(hashmap.contains(num))
                count++;

                else
                break;    
            }
            result = Math.max(result, count);
        }

        return result==1 ? -1 : result;
    }
}