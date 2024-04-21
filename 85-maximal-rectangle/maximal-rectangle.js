/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    let histogram = new Array(matrix[0].length).fill(0);
    histogram.push(0);
    let row = matrix.length;
    let col = matrix[0].length;
    let area = 0;

    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            if(matrix[i][j]==="1")
            histogram[j]+=1;

            else
            histogram[j]=0;
        }
        
        let stack = [];
        for(let k=0;k<histogram.length;k++){
            let heightstart = k;
            while(stack.length && stack[stack.length-1][0]> histogram[k]){
                let [height,pos] = stack.pop();
                area = Math.max(area, height*(k-pos));
                heightstart = pos;
            }
            stack.push([histogram[k], heightstart]);
        }
        
    }
    return area;
};