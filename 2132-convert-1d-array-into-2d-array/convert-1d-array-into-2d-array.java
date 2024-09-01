class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if((original.length%n!=0) || (m*n!=original.length) ){
            return new int[0][0];
        }

        int[][] result = new int[m][n];
        int col=0;

        for(int i=0;i<original.length;i++){
            if(i!=0 && i%n==0){
                col++;
            }
            result[col][i%n]=original[i];
        }

        return result;
    }
}