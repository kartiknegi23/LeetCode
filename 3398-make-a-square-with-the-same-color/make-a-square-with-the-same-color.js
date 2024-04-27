/**
 * @param {character[][]} grid
 * @return {boolean}
 */
var canMakeSquare = function(grid) {

    let n= grid.length;
    for(let i=0;i<2;i++){
        let b=0;
        let w =0;
        for(let j=0;j<2;j++){
            if(grid[i][j]==="B")
            b++;

            else if(grid[i][j]==="W")
            w++;

            if(grid[i+1][j]==="B")
            b++;

            else if(grid[i+1][j]==="W")
            w++;

            if(b>=3 || w>=3)
            return true;
        }

        b=0;
        w=0;

        for(let k=1;k<n;k++){
            if(grid[i][k]==="B")
            b++;

            if(grid[i][k]==="W")
            w++;

            if(grid[i+1][k]==="B")
            b++;

            if(grid[i+1][k]==="W")
            w++;

            if(b>=3 || w>=3)
            return true;
        }
    }

    return false;
    
};