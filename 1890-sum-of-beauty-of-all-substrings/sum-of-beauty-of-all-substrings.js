/**
 * @param {string} s
 * @return {number}
 */
var beautySum = function(s) {
    let sum = 0;
    let arr = [];

    for(let i=0;i<s.length;i++){
        let str = "";
        for(let j=i;j<s.length;j++){
            str+=s[j];

            if(str.length>=2)
            arr.push(str);

        }
    }


    for(let i=0;i<arr.length;i++){
        let array = new Array(26).fill(0);
        for(let j=0;j<arr[i].length;j++){
            
            let index = arr[i].charCodeAt(j) - 'a'.charCodeAt(0);

            array[index]++;

        }


        let max = -Infinity;
        let min = Infinity;

        for(let k=0;k<26;k++){
            if(max<array[k])
            max = array[k];

            if(min>array[k] && array[k]>0)
            min = array[k];
        }


        sum+= (max-min);
    }

    return sum;
};