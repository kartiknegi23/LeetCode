/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    let row = new Array(matrix.length).fill(0);
    let col = new Array(matrix[0].length).fill(0);

    let r = matrix.length;
    let c = matrix[0].length;

    for(let i=0;i<r;i++){
        for(let j=0;j<c;j++){
            if(matrix[i][j]===0){
                row[i]=1;
                col[j]=1;
            }
        }
    }

    for(let i=0;i<r;i++){
        for(let j=0;j<c;j++){
            if(row[i]===1){
                matrix[i][j]=0;
            }

            if(col[j]===1){
                matrix[i][j]=0;
            }
        }
    }

    return matrix;
};