class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = nums[0];
        int[] answer = new int[nums.length];
        int limit = (int)Math.pow(2,maximumBit);
        int mask = limit-1;

        for(int i=1;i<nums.length;i++){
            xor = xor^nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            int k = xor^mask;
            answer[i]=k;
            
            xor = xor^nums[nums.length-1-i];
        }

        return answer;
    }
}