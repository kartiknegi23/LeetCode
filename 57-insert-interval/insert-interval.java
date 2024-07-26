class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();

        int i=0;
        int n=intervals.length;
        if(n==0)
        list.add(newInterval);
        while(i<n){
            while(i<n && intervals[i][1]<newInterval[0]){
                list.add(intervals[i]);
                i++;
            }

            while(i<n && intervals[i][0]<=newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            list.add(newInterval);

            while(i<n){
                list.add(intervals[i]);
                i++;
            }
        }

        int rows = list.size();
        int cols = list.get(0).length;

        int[][] result = new int[rows][cols];

        for(int index=0;index<rows;index++){
            result[index]=list.get(index);
        }

        return result;
    }
}