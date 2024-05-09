/**
 * @param {number[]} happiness
 * @param {number} k
 * @return {number}
 */
var maximumHappinessSum = function(happiness, k) {
    happiness.sort((a,b)=>b-a);
    let sum = 0;

    for(let i=0;i<k;i++){
        let diff = happiness[i]-i;

        if(diff<0)
        diff=0;

        sum=sum+diff;
    }

    return sum;
};