class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            deque.addLast(i);
        }

        while(deque.size()>1){
            for(int i=0;i<k-1;i++){
                deque.addLast(deque.removeFirst());
            }
            deque.removeFirst();
        }

        return deque.peek();
    }
}