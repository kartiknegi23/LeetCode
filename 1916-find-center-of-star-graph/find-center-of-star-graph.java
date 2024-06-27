class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<2;j++){
                if(hashmap.containsKey(edges[i][j]))
                hashmap.put(edges[i][j], hashmap.get(edges[i][j])+1);

                else
                hashmap.put(edges[i][j], 1);
            }
        }

        int center = 0;
        int max = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry : hashmap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                center = entry.getKey();
            }
        }

        return center;
    }
}