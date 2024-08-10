class Solution {

    public void dfs(int[][] arr, int i, int j){
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j]==1)
        return;

        arr[i][j]=1;

        dfs(arr, i, j-1);
        dfs(arr, i, j+1);
        dfs(arr, i-1, j);
        dfs(arr, i+1, j);
    }

    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int[][] arr = new int[m*3][n*3];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j)=='/')
                {
                    arr[i*3][j*3+2] = 1;
                    arr[i*3+1][j*3+1] = 1;
                    arr[i*3+2][j*3] = 1;
                }

                if(grid[i].charAt(j)=='\\'){
                    arr[i*3][j*3] = 1;
                    arr[i*3+1][j*3+1] = 1;
                    arr[i*3+2][j*3+2] = 1;
                }
            }
        }    

        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    dfs(arr, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}