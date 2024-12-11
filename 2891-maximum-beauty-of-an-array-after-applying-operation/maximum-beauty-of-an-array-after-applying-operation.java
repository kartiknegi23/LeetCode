class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer>[] arr = new ArrayList[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = new ArrayList<>();
            arr[i].add(nums[i]-k);
            arr[i].add(nums[i]+k);
        }
        
        int count = 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(arr[0]);

        for(int i=1;i<nums.length;i++){
            int start = arr[i].get(0);
            int end = arr[i].get(1);

            while(queue.size()>0 && queue.peek().get(1)<start){
                queue.poll();
            }
            queue.add(arr[i]);
            count = Math.max(count, queue.size());

        }
        return count;
    }
}