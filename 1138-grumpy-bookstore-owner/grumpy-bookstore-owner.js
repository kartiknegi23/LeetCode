/**
 * @param {number[]} customers
 * @param {number[]} grumpy
 * @param {number} minutes
 * @return {number}
 */
var maxSatisfied = function(customers, grumpy, minutes) {
    let low = 0;
    let high = 0;
    let max = 0;
    let unsatisfied = 0;
    while(high<customers.length){

        if(grumpy[high]===1)
        unsatisfied += customers[high];

        high++;
        max = Math.max(max, unsatisfied);

        if((high-low)>(minutes-1)){
            if(grumpy[low]===1)
            unsatisfied-=customers[low];
            low++;
        }
    }

    let sum = 0;
    for(let i=0;i<customers.length;i++){
        if(grumpy[i]===0)
        sum+=customers[i];
    }
    return sum+max;
};