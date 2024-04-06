/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    let str = "";
    let count = 0;
    let stack = [];
    let map = new Set();

    for(let i=0;i<s.length;i++){
        if(s[i]=="("){
            count++;
            stack.push(i);
        }

        if(s[i]==")"){
            if(count == 0){
                stack.push(i);
            }
            else{
                stack.pop();
                count--;
            }
        }
    }
    console.log(stack);

    for(let i=0;i<stack.length;i++){
        map.add(stack[i]);
    }

    for(let i=0;i<s.length;i++){
        if(map.has(i))
        continue;

        str+=s[i];
    }
    return str;
};