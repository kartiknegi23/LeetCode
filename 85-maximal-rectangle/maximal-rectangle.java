class Solution {

    public int[] calculate_left_min(int[] left_min, int[] row) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < row.length; i++) {

            while (!stack.isEmpty() && ((row[i] - '0') <= (row[stack.peek()]-'0') ) )
                stack.pop();

            if (stack.isEmpty())
                left_min[i] = 0;

            else
                {   
                    left_min[i] = stack.peek()+1;}

            stack.push(i);
            
             
        }
        return left_min;
    }

    public int[] calculate_right_min(int[] right_min, int[] row) {
        Stack<Integer> stack = new Stack<>();
        for (int i = row.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && ((row[i] - '0') <= (row[stack.peek()]-'0') ) )
                stack.pop();

            if (stack.isEmpty())
                right_min[i] = row.length - 1;

            else
                right_min[i] = stack.peek()-1;

            stack.push(i);
        }
        

        return right_min;
    }

    public int maximalRectangle(char[][] matrix) {
        int max_area = 0;
        int[] arr = new int[matrix[0].length];
        Arrays.fill(arr, 0);

        for (int i=0;i<matrix.length;i++) {
            
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1')
                arr[j]++;

                else
                arr[j]=0;
            }


            int[] left_min = new int[matrix[0].length];
            int[] right_min = new int[matrix[0].length];

            left_min = calculate_left_min(left_min, arr);

            right_min = calculate_right_min(right_min, arr);

            for(int j=0;j<matrix[0].length;j++){
                max_area = Math.max(max_area, ((right_min[j] - left_min[j] + 1) * arr[j]));
            }


        }
        return max_area;
    }
}