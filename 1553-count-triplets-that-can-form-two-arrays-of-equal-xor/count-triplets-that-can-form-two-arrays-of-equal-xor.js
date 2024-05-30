/**
 * @param {number[]} arr
 * @return {number}
 */
var countTriplets = function(arr) {
    let count = 0;
    let a = 0;
    let b = 0;
    let c = 0;

    for(let i=0;i<arr.length;i++){
        for(let j=i+1;j<arr.length;j++){
            a = 0;
            b = 0;
            for(let k=i;k<j;k++){
                a=a^arr[k];
            }

            for(let k=j;k<arr.length;k++){
                b = b^arr[k];

                if(a===b)
                count++;
            }

            
        }
    }
    return count;
};