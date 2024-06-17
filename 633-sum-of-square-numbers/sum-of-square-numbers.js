/**
 * @param {number} c
 * @return {boolean}
 */
var judgeSquareSum = function(c) {
    let low = 0;
    let high = Math.floor(Math.sqrt(c));
    let root = 0;

    // while(low<=high){
    //     let mid = Math.floor((low+high)/2);
    //     let product = mid*mid;

    //     if(product===c)
    //     return true;

    //     else if(product<c){
    //         root = mid;
    //         low=mid+1;
    //     }

    //     else
    //     high = mid-1;
    // }

    // low = 0;
    // high = root;

    while(low<=high){
        let sum = (low*low) + (high*high); 

        if(sum == c)
        return true;

        else if(sum < c)
        low++;

        else
        high--;
    }

    return false;
};