class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = 0;

        int pretime = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            int arrival_time = customers[i][0];
            int prepare_time;
            int wait_time;
            if (pretime >= arrival_time) {
                prepare_time = pretime + customers[i][1];
            } else {
                prepare_time = arrival_time + customers[i][1];
            }
            wait_time = prepare_time - arrival_time;
            pretime = prepare_time;
            System.out.println(wait_time);
            sum += wait_time;
        }

        return sum / customers.length;
    }
}