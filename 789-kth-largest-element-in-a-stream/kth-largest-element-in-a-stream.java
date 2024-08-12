class KthLargest {
    int k;
    PriorityQueue<Integer>queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(queue.size()<k){
                queue.add(nums[i]);
            }
            else{
                if(nums[i]>queue.peek())
                {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        
        if(queue.size()>k)
        queue.poll();

        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */