/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
    let hashmap = new Map();
    for(let i=0;i<s.length;i++){
        if(hashmap.has(s[i]))
        hashmap.set(s[i], hashmap.get(s[i])+1);

        else
        hashmap.set(s[i], 1);
    }

    console.log(hashmap);

    let count = 0;
    let odd_count = 0;
    for([key, value] of hashmap){
        if(value%2===1)
        {
            count += (value-1);
            odd_count=1;
        }


        else if(value%2===0)
        count+=value;
    }
    if(odd_count!==0)
    count++;

    return count;
};