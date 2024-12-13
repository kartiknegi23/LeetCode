class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])
            return a[1]-b[1];
            
            return a[0]-b[0];
        });
        boolean[] marked = new boolean[nums.length]; 
        Arrays.fill(marked, false);

        for(int i=0;i<nums.length;i++){
            int[] arr = new int[]{nums[i], i};
            queue.offer(arr);
        }

        while(queue.size()>0){
            int[] arr = queue.poll();
            int val = arr[0];
            int idx = arr[1];

            if(marked[idx]==false){
                score+=val;
                marked[idx]=true;
                if(idx>0)
                marked[idx-1]=true;
                if(idx<nums.length-1)
                marked[idx+1]=true;
            }
        }

        
        return score;

    }
}