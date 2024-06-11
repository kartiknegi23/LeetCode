/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    
    let index = 0;
    for(let i=0;i<arr2.length;i++){
        
        for(let j=0;j<arr1.length;j++){
            if(arr1[j]===arr2[i]){ 
                let temp = arr1[j];
                arr1[j] = arr1[index];
                arr1[index] = temp;
                index++;
            }
        }
    }


    let element = arr2[arr2.length-1];
    index = arr1.indexOf(element);
    let unique = Infinity;
    let part1;
    let part2;

    for(let i=index+1;i<arr1.length;i++){
        if(arr1[i]!==element)
        {
            unique = arr1[i];
            part1 = arr1.slice(0,i);
            part2 = arr1.slice(i,arr1.length);
            break;    
        }

    }

    if(unique!==Infinity)
    {
    part2.sort((a,b)=>a-b);
    part1.push(...part2);
    return part1;
    }

    else
    return arr1;
};