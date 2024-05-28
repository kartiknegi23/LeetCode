/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let low = 0;
    let row = 0;
    let high = matrix[0].length-1;

    while(row<matrix.length){
        while(low<=high){
            
            let mid = Math.floor((low+high)/2);

            if(matrix[row][mid]===target)
            return true;

            else if(matrix[row][mid]>target)
            high = mid-1;

            else
            low = mid+1;

        }

        low = 0;
        high = matrix[0].length-1;

        row++;
        

    }

    return false;
};