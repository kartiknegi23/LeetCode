/**
 * @param {number[]} nums
 * @return {number}
 */


function mergesort(arr,low,high){
    let count = 0;

    if(low>=high)
    return count;

    let mid = Math.floor((low+high)/2);

    count+=mergesort(arr,low,mid);
    count+=mergesort(arr,mid+1,high);

    count+=check(arr,low,mid,high);

    merge(arr,low,mid,high);

    return count;
}

function check(arr,low,mid,high){
    let count = 0;
    let right = mid+1;
    for(let i=low;i<=mid;i++){
        while(right<=high && arr[i]>(2*arr[right])){
            right++;
        }
        count+=(right-(mid+1));
    }
    return count;
}

function merge(arr,low,mid,high){
    let temp = [];
    let left = low;
    let right = mid+1;

    while(left<=mid && right<=high){
        if(arr[left]<=arr[right]){
            temp.push(arr[left]);
            left++;
        }

        else{
            temp.push(arr[right]);
            right++;
        }
    }

    while(left<=mid){
        temp.push(arr[left]);
        left++;
    }

    while(right<=high){
        temp.push(arr[right]);
        right++;
    }

    for(let i=low;i<=high;i++){
        arr[i] = temp[i-low];
    }
}


var reversePairs = function(nums) {
    let low = 0;
    let high = nums.length-1;

    
    return mergesort(nums,low,high);
};