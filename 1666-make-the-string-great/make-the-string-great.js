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

        console.log(stack);

    }

    // if(s[s.length-1]!==stack[stack.length-1] && stack[stack.length-1]!==s[s.length-1].toLowerCase() && stack[stack.length-1]!==s[s.length-1].toUpperCase())
    // stack.push(s[s.length-1]);

    for(let j=0;j<stack.length;j++){
        str+=stack[j];
    }
    return str;
};