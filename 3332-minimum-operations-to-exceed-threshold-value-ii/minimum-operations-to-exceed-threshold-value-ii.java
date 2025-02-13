class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            queue.offer((long) nums[i]);
        }
        int operations = 0;
        int one = 0;
        int two = 0;

        while(queue.size()>=2 && queue.peek()<k){
            long x = queue.poll();
            long y = queue.poll();

            long res = (Math.min(x, y)*2) + Math.max(x,y);
            queue.offer(res);
            operations++;
        }
        return operations;
    }
}