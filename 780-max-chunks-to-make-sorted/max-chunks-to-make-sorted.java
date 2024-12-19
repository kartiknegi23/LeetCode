class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int[] prefix_max = new int[arr.length];
        int[] suffix_min = new int[arr.length];

        prefix_max[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prefix_max[i] = Math.max(arr[i], prefix_max[i-1]);
        } 

        suffix_min[arr.length-1] = arr[arr.length-1];
        for(int i=suffix_min.length-2;i>=0;i--){
            suffix_min[i] = Math.min(arr[i], suffix_min[i+1]);
        } 

        for(int i=0;i<arr.length;i++){
            int premax = i>0 ? prefix_max[i-1] : -1;
            int suffmin = suffix_min[i];

            if(premax<suffmin)
            chunks++;
        }
        return chunks;
    }
}