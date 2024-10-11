class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int target_arrival = times[targetFriend][0];
        int[] departure = new int[times.length];
        Arrays.fill(departure, -1);

        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=0;i<times.length;i++){
            int arrival = times[i][0];
            int depart = times[i][1];

            for(int j=0;j<departure.length;j++){
                if(departure[j]<=arrival)
                {
                    departure[j]=depart;
                
                    if(arrival == target_arrival)
                    return j;

                    break;
                }
            }

        }

        return 0;
    }
}