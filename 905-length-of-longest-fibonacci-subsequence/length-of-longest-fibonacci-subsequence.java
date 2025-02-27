class Solution {
    public int solve(int j, int k, int[] arr, Map<Integer, Integer> map, int[][] dp){
        if(dp[j][k]!=-1)
        return dp[j][k];
        
        int target = arr[k] - arr[j];
        if(map.containsKey(target) && map.get(target) < j){
            int i = map.get(target);
            return dp[j][k] = solve(i, j, arr, map, dp) + 1;
        }
        return dp[j][k] = 2;
    }

    public int lenLongestFibSubseq(int[] arr) {
        int result = 0;

        int[][] dp = new int[arr.length][arr.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }
        
        for(int j=1;j<arr.length;j++){
            for(int k=j+1;k<arr.length;k++){
                int length = solve(j, k, arr, map, dp);
                result = Math.max(result, length);
            }
        }
        return result == 2 ? 0 : result;
    }
}