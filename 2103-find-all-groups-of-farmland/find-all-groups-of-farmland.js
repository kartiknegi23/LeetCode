/**
 * @param {number[][]} land
 * @return {number[][]}
 */
var findFarmland = function(land) {
    let ans = [];

    let row = land.length;
    let col = land[0].length;
    let max_r = -Infinity;
    let max_c = -Infinity;
    let arr = [];

    function dfs(r,c){
        

        if(c<0 || c>=col || r<0 || r>=row || land[r][c]!==1)
        return;

        max_r = Math.max(max_r,r);
        max_c = Math.max(max_c,c);

        land[r][c]=-1;

        dfs(r-1,c);
        dfs(r+1,c);
        dfs(r,c-1);
        dfs(r,c+1);

        console.log(r,c);
    }


    for(let i=0;i<row;i++){
        for(let j=0;j<col;j++){
            arr = [];
            if(land[i][j]===1){
                arr.push(i,j);
                dfs(i,j);
                arr.push(max_r,max_c);
                ans.push(arr);
            }
            max_r = -Infinity;
            max_c = -Infinity;
        }
    }

    return ans;
};