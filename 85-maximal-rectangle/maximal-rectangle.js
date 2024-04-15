/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    let heights = new Array(matrix[0].length+1).fill(0);

    let row = matrix.length;
    let col = matrix[0].length;
    let max = 0;

    for(let rows of matrix){
        let stack = [];

        for(let i=0;i<rows.length;i++){
            heights[i] = (rows[i]==='1') ? heights[i]+1 : 0;
        }

        for(let j=0;j<heights.length;j++){
            let heightstart = j;

            while(stack.length > 0 && stack[stack.length-1][1] > heights[j]){
                let [pos,height] = stack.pop();
                max = Math.max(max, (j-pos)*height);
                heightstart = pos;
            }

            stack.push([heightstart, heights[j]]);
        }
    }

    return max;
};