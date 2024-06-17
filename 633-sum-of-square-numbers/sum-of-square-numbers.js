/**
 * @param {number} c
 * @return {boolean}
 */
var judgeSquareSum = function(c) {
    let low = 0;
    let high = Math.floor(Math.sqrt(c));

    console.log(high);

    while(low<=high){
        let sum = Math.pow(low,2) + Math.pow(high,2); 

        console.log(sum, c);

        if(sum == c)
        return true;

        else if(sum < c)
        low++;

        else
        high--;
    }

    return false;
};