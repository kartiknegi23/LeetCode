/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
var asteroidCollision = function(asteroids) {
    let stack = [];
    let flag = true;

    for(let i=0;i<asteroids.length;i++){
        let element = asteroids[i];

        if((stack.length>0) && (element<0 && stack[stack.length-1]>0))
        while((stack.length>0) && (element<0 && stack[stack.length-1]>0)){

            if(Math.abs(stack[stack.length-1]) === Math.abs(element)){
                stack.pop();
                flag = false;
                break;
            }

            let result = Math.abs(element) > Math.abs(stack[stack.length-1]) ? element : stack[stack.length-1];
            if(result === stack[stack.length-1])
            {   
                element = result;
                flag = false;
            }

            else
            {
                stack.pop();
                flag = true;
            }
        }

        if(flag===true)
        stack.push(asteroids[i]);

        flag = true;
        
    }



    return stack;
};