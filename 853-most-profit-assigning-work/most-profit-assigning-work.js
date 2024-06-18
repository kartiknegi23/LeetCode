/**
 * @param {number[]} difficulty
 * @param {number[]} profit
 * @param {number[]} worker
 * @return {number}
 */
var maxProfitAssignment = function(difficulty, profit, worker) {
    let max_profit = 0;
    let arr = [];

    for(let i=0;i<profit.length;i++){
        arr.push([difficulty[i], profit[i]]);
    }

    arr.sort((a,b)=>a[0]-b[0]);

    for(let i=0;i<worker.length;i++){
        let max = 0;
        for(let j=0;j<arr.length;j++){
            if(arr[j][0] > worker[i])
            break;

            if(arr[j][1] > max)
            max = arr[j][1];
        }
        max_profit+=max;
    }
    return max_profit;    
};