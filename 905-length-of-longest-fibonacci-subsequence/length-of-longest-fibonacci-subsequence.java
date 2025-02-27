class Solution {
    public int solve(int j, int k, int[] arr, Map<Integer, Integer> map){
        int target = arr[k] - arr[j];
        if(map.containsKey(target) && map.get(target) < j){
            int i = map.get(target);
            return solve(i, j, arr, map) + 1;
        }
        return 2;
    }

    public int lenLongestFibSubseq(int[] arr) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }
        
        for(int j=1;j<arr.length;j++){
            for(int k=j+1;k<arr.length;k++){
                int length = solve(j, k, arr, map);
                result = Math.max(result, length);
            }
        }
        return result == 2 ? 0 : result;
    }
}