class Solution {
    public long gridGame(int[][] grid) {
        long remaining_firstrow_sum = 0;
        long remaining_secondrow_sum = 0;
        long result = Long.MAX_VALUE;

        for(int i=0;i<grid[0].length;i++){
            remaining_firstrow_sum+=grid[0][i];
        }

        for(int i=0;i<grid[0].length;i++){
            remaining_firstrow_sum -= grid[0][i];
            long second_score = Math.max(remaining_firstrow_sum, remaining_secondrow_sum);

            result = Math.min(result, second_score);
            System.out.println(result);
            remaining_secondrow_sum += grid[1][i];
        }

        return result;
    }
}