class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (i,j)->{
            return i[0]-j[0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(queue.size()>0 && queue.peek()<start)
            queue.poll();

            queue.add(end);
        }

        return queue.size();
    }
}