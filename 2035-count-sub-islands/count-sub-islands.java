class Solution {
    Boolean flag;

    public void dfs(int[][] grid2, int[][] grid1, int i, int j){
        if(i<0 || i>=grid2.length || j<0 || j>=grid2[0].length || grid2[i][j]==0){
            return;
        }

        grid2[i][j] = 0;

        if(grid1[i][j]!=1){
            flag = false;
        }

        dfs(grid2, grid1, i+1, j);
        dfs(grid2, grid1, i-1, j);
        dfs(grid2, grid1, i, j+1);
        dfs(grid2, grid1, i, j-1);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m= grid2.length;
        int n= grid2[0].length;
        int count=0;

        flag = true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1){
                    dfs(grid2, grid1, i, j);
                    if(flag==true)
                    count++;
                }
                flag=true;
            }
        }

        return count;
    }
}