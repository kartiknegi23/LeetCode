/**
 * @param {number[]} difficulty
 * @param {number[]} profit
 * @param {number[]} worker
 * @return {number}
 */

function binarysearch(maxprofitdifficulty, target){
    let low = 0;
    let high = maxprofitdifficulty.length-1;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        if(maxprofitdifficulty[mid][0]<=target){
            low=mid+1;
        }

        else
        high=mid-1;
    }
    return high;
}

var maxProfitAssignment = function(difficulty, profit, worker) {
    let arr = [];

    for(let i=0;i<profit.length;i++){
        arr.push([difficulty[i], profit[i]]);
    }

    arr.sort((a,b)=>a[0]-b[0]);


    let maxprofitdifficulty = [];

    let max = 0;
    for(let i=0;i<difficulty.length;i++){
        max = Math.max(max, arr[i][1]);
        maxprofitdifficulty.push([arr[i][0], max]);
    }


    let ans = 0;
    for(let i=0;i<worker.length;i++){
        let index = binarysearch(maxprofitdifficulty, worker[i]); 
        if(index>=0 && worker[i]>=maxprofitdifficulty[index][0])
        ans+= maxprofitdifficulty[index][1];
    }

    return ans;
};