/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function(s) {
    let stack = [];
    let str = "";
    for(let i=0;i<s.length;i++){
        if((stack[stack.length-1]!==s[i] && stack[stack.length-1]===s[i].toLowerCase()) || (stack[stack.length-1]!==s[i] && stack[stack.length-1]===s[i].toUpperCase())){
            stack.pop();
        }
        else
        stack.push(s[i]);


    }

    for(let j=0;j<stack.length;j++){
        str+=stack[j];
    }
    return str;
};