class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int sum = 0;
            while(num>0){
                sum += num%10;
                num /= 10;
            }
            if(map.containsKey(sum)){
                result = Math.max(result, nums[i]+map.get(sum));
                if(nums[i] > map.get(sum)){
                    map.put(sum, nums[i]);
                }
            }
            else
            map.put(sum , nums[i]);
        }
        return result;
    }
}