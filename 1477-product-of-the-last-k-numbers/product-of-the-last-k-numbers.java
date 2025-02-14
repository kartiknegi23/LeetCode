class ProductOfNumbers {
    List<Integer> list;
    List<Integer> prefix;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        prefix = new ArrayList<>();
    }
    
    public void add(int num) {
        int n = prefix.size();
        list.add(num);
        if(n==0){
            prefix.add(num);
        }   
        else{
            prefix.add(prefix.get(n-1)*num);
        }
        if(prefix.get(prefix.size()-1) == 0)
        prefix.clear();
    }
    
    public int getProduct(int k) {
        int n = prefix.size();

        if(n == 0 || k>n)
        return 0;

        if(k==n)
        return prefix.get(n-1);

        return prefix.get(n-1)/prefix.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */