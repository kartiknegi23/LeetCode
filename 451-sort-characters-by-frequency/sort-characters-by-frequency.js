/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function(s) {
    let hashmap = new Map();
    let str = "";

    for(let i=0;i<s.length;i++){
        if(hashmap.has(s[i]))
        hashmap.set(s[i], hashmap.get(s[i])+1);

        else
        hashmap.set(s[i], 1);
    }

const entries = Array.from(hashmap.entries());

// Sort the array by values in descending order using the built-in sort method
entries.sort((a, b) => b[1] - a[1]);

// Convert the sorted array back into a map
const sortedMap = new Map(entries);

    for([key,value] of sortedMap){
        for(let i=0;i<value;i++){
            str+=key;
        }
    }

    return str;
};