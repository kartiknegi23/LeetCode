class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] visited = new int[m][n];
        int[][] height = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    visited[i][j] = 1;
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[] row = new int[]{0,0,1,-1};
        int[] col = new int[]{1,-1, 0,0};

        while(q.size()>0){
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            height[i][j] = arr[2];
            

            for(int k=0;k<4;k++){
                int new_i = i+row[k];
                int new_j = j+col[k];

                if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && visited[new_i][new_j]==0)
                {   
                    visited[new_i][new_j]=1;
                    q.offer(new int[]{new_i, new_j, height[i][j]+1});
                }
            }
        }
        return height;
    }
}