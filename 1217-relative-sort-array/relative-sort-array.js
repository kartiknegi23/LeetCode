/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let hashmap = new Map();

    for(let i=0;i<arr1.length;i++){
        if(hashmap.has(arr1[i]))
        hashmap.set(arr1[i], hashmap.get(arr1[i])+1);

        else
        hashmap.set(arr1[i], 1);
    }

    let index = 0;
    for(let i=0;i<arr2.length;i++){
        while(hashmap.get(arr2[i]) > 0){
            arr1[index] = arr2[i];
            index++;
            hashmap.set(arr2[i], hashmap.get(arr2[i])-1);
        }
        hashmap.delete(arr2[i]);
    }

    let remain = [];
    let j=0;

    for([key, value] of hashmap){
        while(value > 0)
        {
            remain.push(key);
            value--;
        }
        hashmap.delete(key);
    }

    remain.sort((a,b)=>a-b);

    for(let i=0;i<remain.length;i++){

        arr1[index] = remain[i];
        index++; 
    }

    return arr1;
};