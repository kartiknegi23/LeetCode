/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let count = 0;
    let flag = true;
    if(x<0)
    flag = false;
    let temp = Math.abs(x);

    while(temp>0){
        temp = Math.floor(temp/10);
        count++;
    }

    console.log(count);

    count-=1;

    let ans = 0;
    temp = Math.abs(x);


    while(count>=0){
        let a = temp%10;
        ans += a*(10**count);
        temp = Math.floor(temp/10);
        count--;
    }

    if(ans > ((2**31)-1))
    return 0;

    return flag ===true ? ans : -ans;
};