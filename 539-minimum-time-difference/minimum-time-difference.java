class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for(int i=0;i<timePoints.size();i++){
            int hour = timePoints.get(i).charAt(0)*10 - '0' + timePoints.get(i).charAt(1) - '0';
            int min = timePoints.get(i).charAt(3)*10 - '0' + timePoints.get(i).charAt(4) - '0';

            int total = hour*60 + min;
            minutes[i] = total; 
        }

        Arrays.sort(minutes);

        int result = Integer.MAX_VALUE;

        for(int i=1;i<minutes.length;i++){
            result = Math.min(result, minutes[i]-minutes[i-1]);
        }

        result = Math.min(result, (24*60 - minutes[minutes.length-1] + minutes[0]));

        return result;
    }
}