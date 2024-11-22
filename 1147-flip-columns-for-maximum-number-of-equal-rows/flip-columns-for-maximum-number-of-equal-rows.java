class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        for(int [] curr_row : matrix){
            int[] inverted = new int[n];
            int count = 0;
            for(int col=0;col<n;col++){
                inverted[col] = 1-curr_row[col];
            }

            for(int[] arr : matrix){
                if(Arrays.equals(arr, curr_row) || Arrays.equals(inverted, arr))
                count++;
            }
            max = Math.max(max, count);
        } 
        return max;
    }
}