class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int result = 0;
        int count = 0;
        boolean[] isflipped = new boolean[nums.length];

        for(int i=0;i<nums.length;i++){
            if(i>=k && isflipped[i-k]==true ){
                count--;
            }
            
            if(count%2==nums[i]){
                if(i+k>nums.length)
                return -1;

                result++;
                count++;
                isflipped[i]=true;
            }


        }
        return result;
    }
}