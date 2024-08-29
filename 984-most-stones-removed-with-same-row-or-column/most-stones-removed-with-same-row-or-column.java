class Solution {
    public void dfs(int[][] stones, int i, boolean[] visited){
        visited[i] = true;
        int r = stones[i][0];
        int c = stones[i][1];

        for(int index=0;index<stones.length;index++){
            if(visited[index]==true)
            continue;

            if(stones[index][0] == r || stones[index][1] == c)
            dfs(stones, index, visited);
        }
    }

    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];

        int groups=0;
        for(int i=0;i<stones.length;i++){
            if(visited[i]==true)
            continue;

            dfs(stones, i, visited);
            groups++;
        }

        return stones.length-groups;
    }
}