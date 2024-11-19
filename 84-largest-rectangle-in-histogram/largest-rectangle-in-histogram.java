class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left_min = new int[heights.length];
        int[] right_min = new int[heights.length];

        int ans = Integer.MIN_VALUE;

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

        stack.clear();
        right_min[right_min.length-1]=right_min.length;
        stack.push(right_min.length-1);
        for(int i=heights.length-2;i>=0;i--){
            while(stack.size()>0 && heights[i]<=heights[stack.peek()])
            stack.pop();

            if(stack.isEmpty())
            right_min[i]=right_min.length;

            else
            right_min[i]=stack.peek();

            stack.push(i);
        }

        for(int i=0;i<heights.length;i++){
            int area = (right_min[i]-left_min[i]-1)*heights[i];
            ans = Math.max(ans, area);
        }

        return ans;
    }
}