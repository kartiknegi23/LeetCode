/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let ans = s.split(" ");
    let n = ans.length;
    let str;
    while(str!=" " && n!==0){
        str = ans[n-1];
        n--;
        if(str!="")
        break;
    }
    return str.length;
};