/**
 * @param {number[]} bloomDay
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
var minDays = function(bloomDay, m, k) {
    if(bloomDay.length<m*k)
    return -1;

    let min = Infinity;
    let max = -Infinity;

    for(let i=0;i<bloomDay.length;i++){
        if(min>bloomDay[i])
        min = bloomDay[i];

        if(max<bloomDay[i])
        max = bloomDay[i];
    }

    let low = min;
    let high = max;

    while(low<=high){
        let mid = Math.floor((low+high)/2);
        let count = 0;
        let bouqeuts = 0;

        for(let i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid)
            count++;

            else{
                bouqeuts += Math.floor(count/k);
                count = 0;
            }
        }
        bouqeuts += Math.floor(count/k);

        if(bouqeuts>=m)
        high=mid-1;

        else
        low=mid+1;
    }

    return low;
};