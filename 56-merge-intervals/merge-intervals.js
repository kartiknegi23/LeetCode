/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a,b)=>a[0]-b[0]);
    let ans = [];

    for(let i=0;i<intervals.length;i++){
        let start = intervals[i][0];
        let end = intervals[i][1];

        if(ans.length>0 && intervals[i][0]<=ans[ans.length-1][1])
        continue;

        for(let j=i+1;j<intervals.length;j++){
            if(intervals[j][0]<=end){
                end = Math.max(end, intervals[j][1]);
            }
            else
            break;
        }
        ans.push([start,end]);
    }

    return ans;
};