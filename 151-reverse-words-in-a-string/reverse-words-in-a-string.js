/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = s.split(" ");
    arr = arr.reverse();
    let ans = "";

    for(let i=0;i<arr.length;i++){
        if(arr[i]==="")
        {arr.splice(i,1);
        i--;}
    }


    for(let i=0;i<arr.length;i++){
        ans+=arr[i];
        if(i<arr.length-1)
        ans+=" ";
    }

    return ans;
};