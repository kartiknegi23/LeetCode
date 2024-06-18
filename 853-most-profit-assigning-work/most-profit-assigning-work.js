/**
 * @param {number[]} difficulty
 * @param {number[]} profit
 * @param {number[]} worker
 * @return {number}
 */
var maxProfitAssignment = function(difficulty, profit, worker) {
    let ans = 0;

    for(let i=0;i<worker.length;i++){
        let max_profit = 0;
        for(let j=0;j<difficulty.length;j++){
            if(difficulty[j]<=worker[i] && profit[j]>max_profit)
            max_profit = profit[j];

        }
        ans+=max_profit;
    }
    return ans;
};