/**
 * @param {string} s
 * @return {number}
 */
var partitionString = function(s) {
    let left = 0;
    let count = 0;
    let hashmap = new Set();

    for(let right=0;right<s.length;right++){

        if(hashmap.has(s[right])){
            while(left<right){
                hashmap.delete(s[left]);
                left++;
            }  
            count++;
        }

        if(!(hashmap.has(s[right]))){
            hashmap.add(s[right]);
        }
    }
    return count+1;
};