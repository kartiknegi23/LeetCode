class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] power = new int[nums.length-k+1];

        for(int i=0;i<=nums.length-k;i++){
            int prev=nums[i];
            boolean flag = true;
            for(int j=i+1;j<i+k;j++){
                if(nums[j]==prev+1)
                prev = nums[j];

                else
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            power[i]=nums[i]+k-1;

            else
            power[i]=-1;
        }

        return power;
    }
}