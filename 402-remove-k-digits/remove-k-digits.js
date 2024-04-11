/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function(num, k) {
    let stack = [];
    let count = k;
    let flag = false;
    str = "";

    for(let i=0;i<num.length;i++){
        while(num[i] < stack[stack.length-1] && stack.length>0 && count>0){
            stack.pop();
            count--;
        }

        stack.push(num[i]);
    }

    //remove remaning element if k is still !==0 (that means we can remove more elements) //
    while(count>0){
        stack.pop(stack.length-1);
        count--;
    }

    console.log(stack);

    
    for(let i=0;i<stack.length;i++){
        if(parseInt(stack[i])===0 && parseInt(stack[i+1])>=0 && flag===false){
            console.log("hello");
            stack.shift();
            i--;
            console.log(stack);
        }

        else if(stack[i]!==0)
        flag = true;
    }

    for(let i=0;i<stack.length;i++){
        str+=stack[i];
    }    

    return str.length===0? "0" : str;
};