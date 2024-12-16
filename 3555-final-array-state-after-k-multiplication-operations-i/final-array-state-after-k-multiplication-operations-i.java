class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])
            return a[1]-b[1];

            return a[0]-b[0]; 
        });
        
        for(int i=0;i<nums.length;i++){
            queue.offer(new int[]{nums[i], i});
        }
        
        while(k>0){
            int[] arr = queue.poll();
            int val = arr[0];
            val = val*multiplier;
            int idx = arr[1];
            queue.offer(new int[]{val,idx});
            k--;
        }

        for(int[] arr : queue){
            int val = arr[0];
            int idx = arr[1];
            nums[idx] = val;
        }

        return nums;
    }
}