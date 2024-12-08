class Solution {

    public int binarySearch(int[][] events, int end_index){
        int left = 0;
        int right = events.length-1;
        int result = events.length;

        while(left<=right){
            int mid = (left+right)/2;

            if(events[mid][0] > events[end_index][1]){
                result = mid;
                right=mid-1;
            }
            else
            left=mid+1;
        }
        return result;
    }

    public int solve(int[][] events, int index, int count, int[][] dp){
        if(index>=events.length || count>=2)
        return 0;

        if(dp[index][count]!=-1)
        return dp[index][count];
        
        int next_valid_index = binarySearch(events, index); 
        //take//
        int take = events[index][2] + solve(events, next_valid_index, count+1, dp);

        //skip//
        int skip = solve(events, index+1, count, dp);

        return dp[index][count] = Math.max(take, skip);
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b)->{
            return a[0]-b[0];
        });

        int[][] dp = new int[events.length][3];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return solve(events, 0, 0, dp);
    }
}