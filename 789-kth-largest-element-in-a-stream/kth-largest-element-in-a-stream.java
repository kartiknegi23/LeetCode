class KthLargest {
    int k;
    ArrayList<Integer>queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        System.out.println(queue);
    }
    
    public int add(int val) {
        queue.add(val);
        Collections.sort(queue);
        return queue.get(queue.size()-k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */