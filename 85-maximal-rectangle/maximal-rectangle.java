class Solution {
    public void calculate_left(int[] left_min ,int[] heights){
        left_min[0]=-1;
        Stack<Integer>stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<heights.length;i++){
            while(stack.size()>0 && heights[i]<=heights[stack.peek()])
            stack.pop();

            if(stack.isEmpty())
            left_min[i]=-1;

            else
            left_min[i]=stack.peek();

            stack.push(i);
        }
    }

    public void calculate_right(int[] right_min ,int[] heights){
        right_min[right_min.length-1]=right_min.length;
        Stack<Integer>stack = new Stack<>();
        stack.push(right_min.length-1);
        for(int i=heights.length-2;i>=0;i--){
            while(stack.size()>0 && heights[i]<=heights[stack.peek()])
            stack.pop();

            if(stack.isEmpty())
            right_min[i]=heights.length;

            else
            right_min[i]=stack.peek();

            stack.push(i);
        }
    }

    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1')
                heights[j]++;

                else
                heights[j]=0;
            }

            int[] left_min = new int[heights.length];
            int[] right_min = new int[heights.length];

            calculate_left(left_min, heights);
            calculate_right(right_min, heights);

            for(int j=0;j<heights.length;j++){
                int area = (right_min[j]-left_min[j]-1)*heights[j];
                ans = Math.max(ans, area);
            }
        }

        return ans;

    }
}