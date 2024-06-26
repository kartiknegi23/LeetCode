class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && i-k==deque.peekFirst())
            deque.removeFirst();

            while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()])
            deque.removeLast(); 

            deque.addLast(i);

            if(i-k+1>=0){
                list.add(nums[deque.peekFirst()]);
            }
        }

         int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();

         return intArray; 
    }
}