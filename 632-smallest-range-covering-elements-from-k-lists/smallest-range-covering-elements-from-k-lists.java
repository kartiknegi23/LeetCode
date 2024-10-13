class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]>queue = new PriorityQueue<>(
            Comparator.comparingInt(a->a[0])
        );
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            queue.offer(new int[]{nums.get(i).get(0), i, 0});
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        while(queue.size() == nums.size()){
            int[] data = queue.poll();
            int minValue = data[0], row = data[1], col = data[2];

            if((maxValue - minValue) < (rangeEnd - rangeStart)){
                rangeStart = minValue;
                rangeEnd = maxValue;
            }

            if(col+1 < nums.get(row).size()){
                int newVal = nums.get(row).get(col+1);
                queue.offer(new int[]{newVal, row, col+1});
                maxValue = Math.max(maxValue, newVal);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}