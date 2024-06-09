/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var numberOfChild = function(n, k) {
    let arr = new Array(n).fill(0);
    let count = 0;
    let index = 0;
    let frontflag = true;
    let backflag = false;
    while(count<k){
        if(backflag === true){
            index--;
            count++;
            if(index===0)
            {backflag = false;
            frontflag = true;}
        }

        else if(frontflag === true){
            index++;
            count++;
            if(index>=(arr.length-1)){
                backflag = true;
                frontflag = false;
            }
        }
    }
    return index;
};