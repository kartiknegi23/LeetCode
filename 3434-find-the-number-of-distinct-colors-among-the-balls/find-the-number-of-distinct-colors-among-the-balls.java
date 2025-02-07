class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> balls = new HashMap<>();
        Map<Integer, Integer> colors = new HashMap<>();
        int[] arr = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            if(balls.containsKey(ball)){
                int old_color = balls.get(ball);
                colors.put(old_color, colors.get(old_color)-1);

                if(colors.get(old_color) == 0){
                    colors.remove(old_color);
                }
            }

            balls.put(ball, color);
            colors.put(color, colors.getOrDefault(color, 0)+1);

            arr[i] = colors.size();
        }
        return arr;
    }
}