/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var largestLocal = function(grid) {
    let n = grid.length;
    let ans = [];

    for(let i=0;i<n-2;i++){
        let max = [];
        for(let j=0;j<n-2;j++){
            let temp = -Infinity;
            for(let k=i;k<i+3;k++){
                for(let l=j;l<j+3;l++){
                    temp=Math.max(temp,grid[k][l]);
                }
            }
            max.push(temp);
        }       
        ans.push(max);
    }
    return ans;
};