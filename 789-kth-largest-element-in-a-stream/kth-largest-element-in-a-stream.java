class KthLargest {
    int k;
    PriorityQueue<Integer>queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num); // Ensure the queue contains only the k largest elements
        }
        System.out.println(queue);
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