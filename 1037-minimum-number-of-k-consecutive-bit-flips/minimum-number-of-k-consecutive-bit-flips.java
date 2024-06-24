class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int count = 0;
        boolean[] isflip = new boolean[nums.length];
        int flipstate = 0;

        for(int i=0;i<nums.length;i++){
            if(i>=k && isflip[i-k]==true)
            flipstate--;

            if((nums[i]==0 && flipstate%2==0) || (nums[i]==1 && flipstate%2==1))
                {   
                    if(i+k>nums.length)
                    return -1;

                    isflip[i] = true;
                    flipstate++;
                    count++;
                }
        
        }
        return count;
    }
}