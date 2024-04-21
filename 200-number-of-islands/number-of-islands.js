/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let count = 0;
    let row = grid.length;
    let col = grid[0].length;

    function dfs(r,c){
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c]==="0" || grid[r][c]===-1)
        return;

        grid[r][c]=-1;

        dfs(r-1,c);
        dfs(r+1,c);
        dfs(r,c-1);
        dfs(r,c+1);
    }

    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            if(grid[i][j]==="1")
            {
                count++;
                dfs(i,j);
            }
        }
    }

    return count;
};