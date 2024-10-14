class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer>queue = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;
        for(int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
        }
        while(k>0){
            
            int top = queue.poll();
            score += top;
            top = (top+2)/3;
            queue.offer(top);
            k--;
        }

        return score;
    }
}