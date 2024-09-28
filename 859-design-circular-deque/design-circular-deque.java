class MyCircularDeque {
    int size;
    int capacity;
    Deque<Integer>deque;
    public MyCircularDeque(int k) {
        size = 0;
        capacity = k;
        deque = new ArrayDeque<>();
    }
    
    public boolean insertFront(int value) {
        if(deque.size()<capacity){
            deque.addFirst(value);
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(deque.size()<capacity){
            deque.addLast(value);
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(deque.size()>0){
            deque.removeFirst();
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(deque.size()>0){
            deque.removeLast();
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(deque.size()>0){
            return deque.peekFirst();
        }
        return -1;
    }
    
    public int getRear() {
        if(deque.size()>0){
            return deque.peekLast();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if(deque.size()==0)
        return true;

        else
        return false;
    }
    
    public boolean isFull() {
        if(deque.size()==capacity)
        return true;

        else
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */