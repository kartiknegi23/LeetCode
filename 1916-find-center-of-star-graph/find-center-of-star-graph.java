class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<2;j++){
                if(hashmap.containsKey(edges[i][j]))
                return edges[i][j];

                else
                hashmap.put(edges[i][j], 1);
            }
        }

        return 0;
    }
}