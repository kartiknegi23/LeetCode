/**
 * @param {number[]} position
 * @param {number} m
 * @return {number}
 */

function checkforce(position, mid, m){
    let count = 1;
    let result = false;
    let prev = position[0];
    for(let i=1;i<position.length;i++){
        if(count===m){
            return true;
        }

        if(position[i]-prev>=mid){
            count++;
            prev = position[i];
        }
    }
    if(count===m)
    return true;

    else
    return false;
}

var maxDistance = function(position, m) {
    position.sort((a,b)=>a-b);

    let low = 1;
    let high = position[position.length-1];
    let result=0;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        if(checkforce(position, mid, m)){
            result = mid;
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }

    return result;
};