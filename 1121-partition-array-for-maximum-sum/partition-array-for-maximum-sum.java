class Solution {
    public int solve(int i, int j, int[] arr, int k, int[] dp){
        if(i>j)
        return 0;

        if(dp[i]!=-1)
        return dp[i];

        int ans = 0;
        int sum = Integer.MIN_VALUE;
        int count = 0; 
        int max = Integer.MIN_VALUE; 
        for(int index=i;index<Math.min(i+k,arr.length);index++){
            count++;
            max = Math.max(max, arr[index]);
            sum = max*count + solve(index+1,j,arr,k, dp);
            ans = Math.max(ans, sum);
        }
        return dp[i] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return solve(0, arr.length-1, arr, k, dp);
    }
}