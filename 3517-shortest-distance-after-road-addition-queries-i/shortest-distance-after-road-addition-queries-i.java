class Solution {
    public int bfs(int n, Map<Integer, List<Integer>> hashmap){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited.add(false);
        }
        visited.set(0, true);

        int level = 0;
        while(queue.size()>0){
            int size = queue.size();
            while(size>0){
                int node = queue.poll();
                if(node==n-1)
                return level;

                for(int num : hashmap.get(node)){
                    if(visited.get(num)==false){
                        queue.add(num);
                        visited.set(num, true);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>>hashmap = new HashMap<>();
        for(int i=0;i<n-1;i++){
            List<Integer> list = new ArrayList<>();
            list.add(i+1);
            hashmap.put(i, list);
        }

        int[] result = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];

            hashmap.get(u).add(v);
            int d = bfs(n, hashmap);
            result[i] = d;
        }

        return result;
    }
}