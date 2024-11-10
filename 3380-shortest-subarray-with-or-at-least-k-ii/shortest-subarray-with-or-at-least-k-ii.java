class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int or = 0;
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int[] map = new int[32];

        while(right<nums.length){
            or = or | nums[right];
            
            int num = nums[right];
            for(int i=0;i<32;i++){
                map[i] = map[i] + num%2;
                num/=2;
            }

            while(left<=right && left<nums.length && or>=k){
                length = Math.min(length, right-left+1);

                int n = nums[left];
                for(int i=0;i<32;i++){
                    map[i] = map[i] - n%2;
                    n/=2;
                }

                int new_or = 0;
                for(int i=0;i<32;i++){
                    new_or = map[i]>0 ? (new_or + (int)Math.pow(2,i)) : (new_or + 0);
                }
                or = new_or;

                left++;
            }

            right++;
        }

        return length==Integer.MAX_VALUE ? -1 : length;
    }
}