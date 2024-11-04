class Solution {
    public int solve(int i, int j, List<Integer>list, int[][] dp){
        if(i>j)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int index=i;index<=j;index++){
            int cost = list.get(i-1)*list.get(index)*list.get(j+1) + solve(i,index-1,list, dp) + solve(index+1, j, list, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        List<Integer>list = new ArrayList<>();
        list.add(1);
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        list.add(1);
        int[][] dp = new int[list.size()][list.size()];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(1, list.size()-2, list, dp);
    }
}