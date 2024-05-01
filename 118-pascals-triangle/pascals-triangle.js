/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    let ans = [];

    for(let i=0;i<numRows;i++){
        let arr = new Array(i+1);
        for(let j=0;j<=i;j++){
            if(j==0 || j==i)
            {arr[j]=1;
            }

            else{
                arr[j] = ans[i-1][j-1] + ans[i-1][j];
            }
            
        }
        ans.push(arr);
    }
    return ans;
};