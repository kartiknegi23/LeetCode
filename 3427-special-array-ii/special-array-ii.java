class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];
        boolean[] result = new boolean[queries.length];
        prefix[0] = 0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]%2 == nums[i-1]%2)
            prefix[i] = prefix[i-1]+1;

            else
            prefix[i] = prefix[i-1];
        }
        
        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = prefix[end]-prefix[start] == 0 ? true : false;    
        }

        return result;
    }
}