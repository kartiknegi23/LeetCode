class CustomStack {
    List<Integer> stack;
    int capacity;

    public CustomStack(int maxSize) {
        capacity = maxSize;
        stack = new ArrayList<>();
    }
    
    public void push(int x) {
        if(stack.size()<capacity){
            stack.add(x);
        }
    }
    
    public int pop() {
        if(stack.size()>0)
        {   
            int rem = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return rem;
        }

        else
        return -1;
    }
    
    public void increment(int k, int val) {
        int min = Math.min(k, stack.size());
        for(int i=0;i<min;i++){
            stack.set(i, stack.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */