/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */

function setrow(nums,i,col){
    for(let j=0;j<col;j++){
        if(nums[i][j]!==0)
        nums[i][j]="marked";
    }
}

function setcol(nums,j,row){
    for(let i=0;i<row;i++){
        if(nums[i][j]!==0)
        nums[i][j]="marked";
    }
}

var setZeroes = function(matrix) {
    
    let row = matrix.length;
    let col = matrix[0].length;


    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            if(matrix[i][j]===0){
                setrow(matrix,i,col);
                setcol(matrix,j,row);
            }
        }
    }

    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            if(matrix[i][j]==="marked")
            matrix[i][j]=0;
        }
    }

    return matrix;
};