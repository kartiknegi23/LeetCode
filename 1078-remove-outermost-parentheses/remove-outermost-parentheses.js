/**
 * @param {string} s
 * @return {string}
 */
var removeOuterParentheses = function(s) {
    let stack = [];
    let str = "";
    for(let i=0;i<s.length;i++){
        if(i==0 || s[i]==='(')
        {
            stack.push(s[i]);
            if(stack.length>1)
            str+=s[i];    
        }

        else if(s[i]===')')
        {
            stack.pop();
            if(stack.length>0)
            str+=s[i];
        }

    }

    return str;
};