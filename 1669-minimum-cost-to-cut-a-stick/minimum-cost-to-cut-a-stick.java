class Solution {
    public int solve(int i, int j, List<Integer> list, int[][] dp){
        if(i>j)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int index=i;index<=j;index++){
            int cost = list.get(j+1)-list.get(i-1) + solve(i,index-1,list, dp) + solve(index+1,j,list, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        List<Integer>list = new ArrayList<>();
        list.add(0);
        for(int i=0;i<cuts.length;i++){
            list.add(cuts[i]);
        }
        list.add(n);
        Collections.sort(list);
        int[][] dp = new int[list.size()][list.size()];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(1, list.size()-2, list, dp);
    }
}