class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long count = 0;
        long sum = 0;
        long min = Long.MAX_VALUE;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0)
                count++;

                if(min>Math.abs(matrix[i][j]))
                min = Math.abs(matrix[i][j]);

                sum += Math.abs(matrix[i][j]);
            }
        }

        if(count%2==0)
        return sum;

        return sum-min-min;
    }
}