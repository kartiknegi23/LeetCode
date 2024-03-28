/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let left = 0;
    let count = 0;
    let hashmap = new Map();

    for(let right = 0 ; right< s.length; right++){
        if(hashmap.has(s[right]))
        hashmap.set(s[right], hashmap.get(s[right])+1);

        else
        hashmap.set(s[right], 1);

        while(hashmap.get(s[right]) > 1){
            hashmap.set(s[left], hashmap.get(s[left])-1);
            left++;
        }

        count = Math.max(count, right - left + 1);

    }

    return count;
};