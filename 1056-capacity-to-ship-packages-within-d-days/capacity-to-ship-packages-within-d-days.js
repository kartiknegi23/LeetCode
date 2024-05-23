/**
 * @param {number[]} weights
 * @param {number} days
 * @return {number}
 */

function check(weights,mid,days){
    let count = 1;
    let sum = 0;
    for(let i=0;i<weights.length;i++){
        sum+=weights[i];

        if(sum>mid)
        {
            count++;
            sum=weights[i];
        }

        if(count>days){
            return count;
        }
    }

    return count;
}

var shipWithinDays = function(weights, days) {
    let min = -Infinity;
    let max = 0;


    for(let i=0;i<weights.length;i++){
        min = min < weights[i] ? weights[i] : min;

        max+=weights[i];
    }

    let low = min;
    let high = max;
    let ans = -1;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        let count = check(weights,mid,days);

        if(count<=days){
            ans = mid;
            high=mid-1;
        }

        else
        low=mid+1;

    }


    return ans;
};