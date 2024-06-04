/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if(s.length===1)
    return false;

    let stack = [];

    for(let i=0;i<s.length;i++){

        if(stack.length === 0 && (s[i]===')' || s[i]===']' || s[i]==='}'))
        return false;

        if(s[i]==='(' || s[i]==='{' || s[i]==='[')
        stack.push(s[i]);

        else{
            if(s[i]===')' && stack[stack.length-1]==='(')
            stack.pop();

            else if(s[i]===']' && stack[stack.length-1]==='[')
            stack.pop();

            else if(s[i]==='}' && stack[stack.length-1]==='{')
            stack.pop();

            else
            return false;
        }
    }
    if(stack.length>0)
    return false;

    else return true;
};