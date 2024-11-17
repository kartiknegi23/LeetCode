class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int length = Integer.MAX_VALUE;
        long[] prefix_sum = new long[nums.length];

        int right = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        while(right<nums.length){
            if(right==0)
            prefix_sum[right] = nums[right];

            else
            prefix_sum[right] = prefix_sum[right-1] + nums[right];

            if(prefix_sum[right]>=k)
            length = Math.min(length, right+1);

            while(deque.size()>0 && prefix_sum[right]-prefix_sum[deque.getFirst()]>=k){
                int front = deque.getFirst();
                length = Math.min(length, right-front);
                deque.removeFirst();
            }

            while(deque.size()>0 && prefix_sum[deque.getLast()]>=prefix_sum[right])
            deque.removeLast();

            deque.add(right);

            right++;
        }

        return length==Integer.MAX_VALUE ? -1 : length;
    }
}