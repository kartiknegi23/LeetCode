class Solution {
    public int dfs(int[][] grid, int i, int j, int[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || visited[i][j]!=0)
        return 0;

        int counter = grid[i][j];
        visited[i][j] = 1;

        int[] row = new int[]{0, 0, -1, 1};
        int[] col = new int[]{1, -1, 0, 0};

        for(int k=0;k<4;k++){
            int new_i = i+row[k];
            int new_j = j+col[k];

            counter += dfs(grid, new_i, new_j, visited);
        }
        return counter;
    }

    public int findMaxFish(int[][] grid) {
        int fish = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0 && visited[i][j]!=1){
                    int count = dfs(grid, i, j, visited);
                    fish = Math.max(fish, count);
                }
            }
        }
        return fish;
    }
}