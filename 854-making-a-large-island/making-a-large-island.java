class Solution {
    public int dfs(int[][] grid, int i, int j, int island_id){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1)
        return 0;

        grid[i][j]=island_id;
        int count = 1; 

        int[] row = new int[]{0,0,1,-1};
        int[] col = new int[]{1,-1,0,0};

        for(int k=0;k<4;k++){
            int new_i = i+row[k];
            int new_j = j+col[k];

            count+= dfs(grid, new_i, new_j, island_id);
        }
        return count;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int island_id = 2;
        int result = 0;

        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area = dfs(grid, i, j, island_id);
                    hashmap.put(island_id, area);
                    result = Math.max(result, area);
                    island_id++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int area = 1;
                if(grid[i][j]==0){
                    Set<Integer> set = new HashSet<>();
                    int[] row = new int[]{0,0,1,-1};
                    int[] col = new int[]{1,-1,0,0};
                    for(int k=0;k<4;k++){
                        int new_i = i+row[k];
                        int new_j = j+col[k];
                        if(new_i>=0 && new_i<n && new_j>=0 && new_j<n && grid[new_i][new_j]!=0 && (!set.contains(grid[new_i][new_j])) ){
                            int island_area = hashmap.getOrDefault(grid[new_i][new_j], 0);
                            area += island_area;
                            set.add(grid[new_i][new_j]);
                        }
                    }
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }
}