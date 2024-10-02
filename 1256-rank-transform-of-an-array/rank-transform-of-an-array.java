class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0)
        return new int[]{};

        int[] rank = arr.clone();
        Arrays.sort(rank);
        Map<Integer, Integer> hashmap = new HashMap<>();
        int num = 1;
        hashmap.put(rank[0], num);

        for(int i=1;i<arr.length;i++){
            if(rank[i]==rank[i-1]){
                continue;
            }
            else{
                num++;
                hashmap.put(rank[i], num);
            }
        }

        for(int i=0;i<arr.length;i++){
            rank[i] = hashmap.get(arr[i]);
        }

        return rank;
        
    }
}