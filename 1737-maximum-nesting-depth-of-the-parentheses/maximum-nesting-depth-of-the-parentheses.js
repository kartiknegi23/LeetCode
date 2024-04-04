/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    let stack = [];
    let depth = 0;

    for(let i=0;i<s.length;i++){
        if(s[i]== "(")
        stack.push(s[i]);

        if(s[i] == ")"){
            depth = Math.max(depth, stack.length);
            stack.pop(s[i]);
        }
    }
    return depth;
};