class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double result = 0;
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> {
            double gainA = (a[1]+1)/(a[2]+1) - a[0];
            double gainB = (b[1]+1)/(b[2]+1) - b[0];
            return Double.compare(gainB, gainA);    
        });


        for(int i=0;i<classes.length;i++){
            double pass = classes[i][0];
            double total = classes[i][1];
            double[] arr = new double[]{pass/total,pass,total};
            queue.offer(arr);
        }

        while(extraStudents>0){
            double[] arr = queue.poll();
            double pass = arr[1];
            double total = arr[2];
            pass+=1;
            total+=1;
            queue.offer(new double[]{pass/total,pass,total});
            extraStudents--;
        }

        for(double[] arr : queue){
            result+=arr[0];
        }
        return result/classes.length;
    }
}