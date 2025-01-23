class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row_count = new int[m];
        int[] col_count = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    row_count[i]++;
                    col_count[j]++;
                }
            }
        }

        int count = 0;

        System.out.println(Arrays.toString(row_count));
        System.out.println(Arrays.toString(col_count));

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    if(row_count[i]>1)
                    count++;

                    else if(col_count[j]>1)
                    count++;
                }
            }
        }
        return count;
    }
}