/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    let n1 = version1.length;
    let n2 = version2.length;

    let length = n1>n2? n1:n2;
    console.log(length);
    let count1=0;
    let count2=0;

    let j=0;
    for(let i=0;i<length;i++){

        while(i<n1 && version1[i]!="."){
            count1=count1*10+parseInt(version1[i]);
            i++;
        }

        while(j<n2 && version2[j]!=="."){
            count2=count2*10+parseInt(version2[j]);
            j++;
        }

        console.log(count1, count2);

        if(count1<count2)
        return -1;

        else if(count1>count2)
        return 1;

        count1=0;
        count2=0;
        j++;
    }

    return 0;
};