/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */

function calculate(mid,piles){
    let count = 0;
    for(let i=0;i<piles.length;i++){
        count+= Math.ceil(piles[i]/mid);
    }
    return count;
}

var minEatingSpeed = function(piles, h) {
    let max = -Infinity;

    for(let i=0;i<piles.length;i++){
        if(piles[i]>max)
        max = piles[i];
    }


    let low = 1;
    let ans = -1;
    let high = max;
    let min = Infinity;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        min = calculate(mid,piles);
        
        if(min<=h){
            ans = mid;
            high=mid-1;
        }

        else{
            low=mid+1;
        }

    }

    return ans;
};