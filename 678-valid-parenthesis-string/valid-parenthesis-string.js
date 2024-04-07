/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
    let stack = [];
    let asterisk = [];

    for(let i=0;i<s.length;i++){
        if(s[i]==="("){
            stack.push(i);
        }

        else if(s[i]==="*"){
            asterisk.push(i);
        }

        else if(s[i]===")"){
            if(stack.length > 0)
            stack.pop();

            else if(asterisk.length > 0)
            asterisk.pop();

            else
            return false;
        }
    }

    while(stack.length && asterisk.length){
        if(stack[stack.length-1] < asterisk[asterisk.length-1]){
            stack.pop();
            asterisk.pop();
        }
        else
        return false;
    }

    return stack.length===0;
};