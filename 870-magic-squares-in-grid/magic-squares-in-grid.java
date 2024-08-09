class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid[0].length<3 || grid.length<3)
        return 0;

        int count = 0;

        int row = 0;
        
        while(row+2<grid.length){
            int col = 0;
            while(col+2<grid[0].length){
            int sum0 = grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
            boolean flag = true;
            

            Set<Integer> set = new HashSet<>();
            // Row Wise //
            for(int i=row;i<row+3;i++){
                int sum = 0;
                for(int j=col;j<col+3;j++){
                    if(1 <= grid[i][j] && grid[i][j]<=9)
                    {   
                        if(set.contains(grid[i][j])){
                            flag = false;
                            break;
                        }
                        else{
                            
                            set.add(grid[i][j]);
                            sum += grid[i][j];
                        }
                    }

                    else{
                        flag = false;
                        break;
                    }
                }
                if(sum!=sum0 || flag == false)
                {   flag = false;
                    break;
                }
            }

            
            // Col Wise //
            for(int j=col;j<col+3;j++){
                int sum = 0;
                for(int i=row;i<row+3;i++){
                    sum += grid[i][j];
                }
                if(sum!=sum0)
                {   
                    flag = false;
                    break;
                }
            }

            int diagonal1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
            int diagonal2 = grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col];

            if(flag == true && sum0 == diagonal1 && sum0 == diagonal2)
            count++;

            col++;
            
            }
            row++;
        }
        
        return count;
    }
}