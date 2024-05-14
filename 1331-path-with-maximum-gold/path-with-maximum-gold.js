/**
 * @param {number[][]} grid
 * @return {number}
 */

function dfs(grid,i,j,row,col){
    if(i<0 || i>=row || j>=col || j<0 || grid[i][j]===0){
        return 0;
    }

    let temp = grid[i][j];
    grid[i][j]=0;

    let left = dfs(grid,i,j-1,row,col);
    let right = dfs(grid,i,j+1,row,col);
    let up = dfs(grid,i-1,j,row,col);
    let down = dfs(grid,i+1,j,row,col);

    let count = temp+Math.max(up,down,left,right);

    grid[i][j]=temp;

    return count;

}

var getMaximumGold = function(grid) {
    let row = grid.length;
    let col = grid[0].length;
    let max = 0;

    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            if(grid[i][j]!==0)
            max=Math.max(max,dfs(grid,i,j,row,col));
        }
    }

    return max;
};