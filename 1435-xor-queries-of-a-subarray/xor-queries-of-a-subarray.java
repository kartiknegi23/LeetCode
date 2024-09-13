class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xor = 0;
        int[] presum = new int[arr.length];
        int[] result = new int[queries.length];
        for(int i=0;i<arr.length;i++){
            xor = xor^arr[i];
            presum[i] = xor;
        }

        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];

            if(left!=0)
            result[i] = presum[right] ^ presum[left-1];

            else
            result[i] = presum[right];
        }

        return result;
    }
}