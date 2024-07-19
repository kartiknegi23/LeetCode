class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer>min = new HashSet<>();
        Set<Integer>max = new HashSet<>();
        List<Integer>result = new ArrayList<>();

        
        for(int i=0;i<matrix.length;i++){
            int small = matrix[i][0];
            for(int j=1;j<matrix[0].length;j++){
                small = Math.min(small, matrix[i][j]);
            }
            min.add(small);
        }

        for(int i=0;i<matrix[0].length;i++){
            int large = Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                large = Math.max(large, matrix[j][i]);
            }
            max.add(large);
        }

        for(Integer key: min){
            if(max.contains(key))
            result.add(key);
        }

        return result;
    }
}