/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {

    if(s.length!==t.length)
    return false;

    let hashmap1 = new Map();
    let hashmap2 = new Map();

    for(let i=0;i<s.length;i++){
        if(hashmap1.has(s[i]))
        hashmap1.set(s[i], hashmap1.get(s[i])+1);

        else
        hashmap1.set(s[i], 1);


        if(hashmap2.has(t[i]))
        hashmap2.set(t[i], hashmap2.get(t[i])+1);

        else
        hashmap2.set(t[i], 1);

    }

    for([key, value] of hashmap1){

        if(hashmap2.has(key)){
            if(hashmap2.get(key)!==value)
            return false;
        }

        if(!(hashmap2.has(key)))
        return false;
    }

    return true;

};