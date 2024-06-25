class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left_min = new int[heights.length];
        int[] right_min = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()])
            stack.pop();

            if(!stack.isEmpty())
            left_min[i]=stack.peek()+1;

            else
            left_min[i]= 0;

            stack.push(i);
        }

        System.out.print("Left_Min-"+Arrays.toString(left_min));
        stack.clear();

        for(int j=heights.length-1;j>=0;j--){
            while(!stack.isEmpty() && heights[j]<=heights[stack.peek()])
            stack.pop();

            if(stack.isEmpty())
            right_min[j]=heights.length-1;

            else
            right_min[j]=stack.peek()-1;

            stack.push(j);
        }

        System.out.print("Right_Min-"+Arrays.toString(right_min));

        int area = 0;
        for(int i=0;i<heights.length;i++){
            area = Math.max(area, ((right_min[i]-left_min[i]+1)*heights[i]) );
        }

        return area;
    }
}