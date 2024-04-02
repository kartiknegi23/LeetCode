/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {

    if(s.length!==t.length)
    return false;

    let hashmap = new Map();
    let hashmap2 = new Map();

    for(let i=0;i<s.length;i++){
        if(hashmap.has(s[i]) || hashmap2.has(t[i]))
        {
            if(hashmap.get(s[i]) === t[i])
            continue;

            else
            return false;
        }

        else{
        hashmap.set(s[i], t[i]);
        hashmap2.set(t[i], s[i]);
        }
    }

    return true;

};