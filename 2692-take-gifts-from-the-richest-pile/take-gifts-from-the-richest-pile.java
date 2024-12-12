class Solution {
    public long pickGifts(int[] gifts, int k) {
        long remaining = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<gifts.length;i++){
            queue.offer(gifts[i]);
        }

        while(k>0){
            int max = queue.poll();
            int keep = (int) Math.floor(Math.sqrt(max));
            queue.offer(keep);
            k--;
        }

        for(int num : queue){
            remaining+=num;
        }
        return remaining;
    }
}