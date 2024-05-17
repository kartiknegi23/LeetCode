/**
 * @param {number[]} bloomDay
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
var minDays = function(bloomDay, m, k) {
    let max = -Infinity;
    let min = Infinity;

    if(m*k>bloomDay.length)
    return -1;

    for(let i=0;i<bloomDay.length;i++){
        if(max<bloomDay[i])
        max=bloomDay[i];

        if(min>bloomDay[i])
        min=bloomDay[i];
    }


    let low = min;
    let high = max;

    while(low<=high){

        let mid = Math.floor((low+high)/2);

            let count = 0;
            let total = 0;
        for(let j=0;j<bloomDay.length;j++){
            if(bloomDay[j]<=mid){
                count++;
            }
            else{
                total += Math.floor(count/k);
                count=0;
            }
        }
        total += Math.floor(count/k);
        console.log(total);
        if(total>=m)
        {
            high = mid-1;
        }

        else{
            low=mid+1;
        }

    }

    return low;

    
};