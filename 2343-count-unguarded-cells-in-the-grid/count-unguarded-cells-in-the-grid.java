class Solution {
    public void solve(int row, int col, int[][] arr, int m, int n){

        //left//
        for(int j=col-1;j>=0;j--){
            if(arr[row][j]==2 || arr[row][j]==3)
            break;

            arr[row][j]=1;
        }

        //right//
        for(int j=col+1;j<n;j++){
            if(arr[row][j]==2 || arr[row][j]==3)
            break;
            arr[row][j]=1;
        }

        //up//
        for(int i=row-1;i>=0;i--){
            if(arr[i][col]==2 || arr[i][col]==3)
            break;
            arr[i][col]=1;
        }

        //down
        for(int i=row+1;i<m;i++){
            if(arr[i][col]==2 || arr[i][col]==3)
            break;
            arr[i][col]=1;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];

        for(int i=0;i<walls.length;i++){
            int row = walls[i][0];
            int col = walls[i][1];
            arr[row][col] = 2;
        }

        for(int i=0;i<guards.length;i++){
            int row = guards[i][0];
            int col = guards[i][1];
            arr[row][col] = 3;
        }

        // for(int[] ar : arr)
        // System.out.println(Arrays.toString(ar));
        // System.out.println("\n");

        for(int i=0;i<guards.length;i++){
            int row = guards[i][0];
            int col = guards[i][1];
            solve(row, col, arr, m, n);
        }

        // for(int[] ar : arr)
        // System.out.println(Arrays.toString(ar));

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0)
                count++;
            }
        }

        return count;
    }
}