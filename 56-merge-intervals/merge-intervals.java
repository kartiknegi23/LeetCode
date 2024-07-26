class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][0];
        }

        ArrayList<int[]>list = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        System.out.println(Arrays.deepToString(intervals));

        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
            else{
                list.add(new int[]{start,end});
                    start=intervals[i][0];
                    end = intervals[i][1];
            }
        }
        
        list.add(new int[]{start, end});

        int[][] result = list.toArray(new int[list.size()][]);

        return result;

    }
}