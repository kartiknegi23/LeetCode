class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] arr = new int[rows*cols][2];

        int[][] directions = {
            {0,1}, 
            {1,0}, 
            {0,-1}, 
            {-1,0}
        };

        int dir = 0;
        int steps = 0;
        int index = 0;

        arr[index][0] = rStart;
        arr[index][1] = cStart;
        index++;

        while(index<rows*cols){
            if(dir%2 == 0)
            steps++;

            for(int i=0;i<steps;i++){
                rStart = rStart + directions[dir%4][0];
                cStart = cStart + directions[dir%4][1];

                if((rStart>=0 && rStart<rows) && (cStart>=0 && cStart<cols)){
                    arr[index][0] = rStart;
                    arr[index][1] = cStart;
                    index++;
                }
            }
            dir++;
        }

        return arr;
    }
}