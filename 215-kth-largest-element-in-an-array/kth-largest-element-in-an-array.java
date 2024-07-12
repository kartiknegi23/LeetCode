class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }

        int count=0;
        while(count<k-1){
            queue.remove();
            count++;
        }

        return queue.remove();
    }
}