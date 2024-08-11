class Solution {
    int m;
    int n;

    public int calculate_islands(int[][] grid){
        int result = 0;

        int[][] visited = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    dfs(grid, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid, int i, int j, int[][] visited){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]==1 || grid[i][j]==0)
        return;

        visited[i][j]=1;

        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] visited = new int[m][n];

        int islands = calculate_islands(grid);
        if(islands<1 || islands>1)
        return 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(calculate_islands(grid)!=1)
                    return 1;

                    grid[i][j]=1;
                }
            }
        }

        return 2;
    }
}