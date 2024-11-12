class Solution {
    public int bsearch(int[][] items, int price){
        int max = 0;
        int left = 0;
        int right = items.length-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(items[mid][0] > price){
                right = mid-1;
            }

            else{
                max = Math.max(max, items[mid][1]);
                left = mid+1;
            }
        } 

        return max;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answers = new int[queries.length];

        Arrays.sort(items, (a,b)->{
           return a[0]-b[0];
        });

        int max = 0;
        for(int i=0;i<items.length;i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        
        for(int i=0;i<queries.length;i++){
            int result = bsearch(items, queries[i]);
            answers[i] = result;
        }
        
        return answers;
    }
}