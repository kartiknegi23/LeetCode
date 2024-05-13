/**
 * @param {number[][]} grid
 * @return {number}
 */
var matrixScore = function(grid) {
    let row = grid.length;
    let col = grid[0].length;

    for(let i=0;i<row;i++){
        let flag = false;
        for(let j=0;j<col;j++){
            if(grid[i][0]===0){
                flag = true;
            }
            if(flag){
                grid[i][j]= Math.abs(grid[i][j]-1);
            }
        }
    }


    for(let j=0;j<col;j++){
        let count1 = 0;
        let count0 = 0;
        for(let i=0;i<row;i++){
            if(grid[i][j]===1)
            count1++;

            else
            count0++;
        }

        if(count1<count0){
            for(let i=0;i<row;i++){
                grid[i][j]= Math.abs(grid[i][j]-1);
            }
        }
    }

    let sum=0;
    for(let i=0;i<row;i++){
        let str = "";
        for(let j=0;j<col;j++){
            str+=grid[i][j];
        }
        str= parseInt(str,2);
        sum+=str;
    }

    return sum;
};