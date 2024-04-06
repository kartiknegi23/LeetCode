/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    let str = "";
    let stack = [];
    let index = [];

    for(let i=0;i<s.length;i++){
        if(s[i]=="("){
            stack.push(s[i]);
            index.push(i);
        }

        if(s[i]==")"){
            if(stack.length==0){
                index.push(i);
            }
            else{
                stack.pop();
                index.pop();
            }
        }

    }

    for(let i=0;i<s.length;i++){
        if(index.includes(i))
        continue;

        str+=s[i];
    }
    return str;
};