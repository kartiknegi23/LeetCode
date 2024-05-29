/**
 * @param {number[][]} mat
 * @return {number[]}
 */

function checkmax(mat, mid){
    let max = -Infinity;
    let row = 0;

    for(let i=0;i<mat.length;i++){
        if(max<mat[i][mid])
        {
            max = mat[i][mid];
            row = i;
        }
    }
    return row;
}

var findPeakGrid = function(mat) {
    let low = 0;
    let high = mat[0].length-1;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        let max_row = checkmax(mat,mid);

        console.log(max_row);

        let left = mid-1>=0 ? mat[max_row][mid-1] : -1;
        let right = mid+1<=mat[0].length-1 ? mat[max_row][mid+1] : -1;

        if(mat[max_row][mid] > left && mat[max_row][mid] > right)
        return [max_row,mid];

        else if(mat[max_row][mid] < left){
            high = mid-1;
        }

        else{
            low = mid+1;
        }
    }
};