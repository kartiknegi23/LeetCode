class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        int maxi = 0;

        for(int i=1;i<lis.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && lis[i]<lis[j]+1){
                    lis[i] = lis[j]+1;
                    count[i] = count[j];
                }

                else if(nums[i] > nums[j] && lis[i]==lis[j]+1){
                    count[i]+=count[j];
                }
            }
            if(maxi < lis[i])
            maxi = lis[i];
        }

        int result = 0;
        for(int i=0;i<count.length;i++){
            if(lis[i]==maxi)
            result += count[i];
        }

        return result==0 ? 1 : result;
    }
}