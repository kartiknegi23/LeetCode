/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
    let row = grid.length;
    let col = grid[0].length;
    let perimeter = 0;

    function dfs(r, c){
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c]===0)
        return 1;

        if(grid[r][c]===-1)
        return 0;

        grid[r][c]=-1;

        return (dfs(r-1,c)+dfs(r+1,c)+dfs(r,c-1)+dfs(r,c+1));
    }

    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            if(grid[i][j]===1)
            perimeter+=dfs(i,j);
        }
    }

    return perimeter;
};