/**
 * @param {number[]} nums
 * @return {number[]}
 */

function mergesort(arr,low, high){
    if(low===high)
    return;

    let mid = Math.floor((low+high)/2);

    mergesort(arr,low,mid);
    mergesort(arr,mid+1,high);

    merge(arr,low,mid,high);
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
        arr[i]=temp[i-low];
    }
}


var sortArray = function(nums) {
  let low = 0;
  let high = nums.length-1;

  mergesort(nums,low,high);

  return nums;  
};