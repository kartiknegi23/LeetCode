class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] freq_row = new int[m];
        int[] freq_col = new int[n];

        Map<Integer, Integer[]> hashmap = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                hashmap.put(mat[i][j], new Integer[]{i,j});
            }
        }

        for(int i=0;i<arr.length;i++){
            Integer[] ar = hashmap.get(arr[i]);
            int row = ar[0];
            int col = ar[1];

            freq_row[row]++;
            freq_col[col]++;

            if(freq_row[row] == n || freq_col[col] == m)
            return i;   
        }

        return 0;
    }
}