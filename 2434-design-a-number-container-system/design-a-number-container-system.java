class NumberContainers {
    Map<Integer, TreeSet<Integer>> numbermap;
    Map<Integer, Integer> idxmap;
    public NumberContainers() {
        numbermap = new HashMap<>();
        idxmap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxmap.containsKey(index)){
            int del_num = idxmap.get(index);
            TreeSet<Integer> set = numbermap.get(del_num);
            set.remove(index);
            idxmap.put(index, number);

        }

        if(numbermap.containsKey(number)){
            numbermap.get(number).add(index);
            idxmap.put(index, number);
        }
        else
        {
            numbermap.put(number, new TreeSet<>());
            numbermap.get(number).add(index);
            idxmap.put(index, number);
        }
    }
    
    public int find(int number) {
        if(!numbermap.containsKey(number))
        return -1;

        TreeSet<Integer> set = numbermap.get(number);
        if(set.size()==0)
        return -1;
        Integer first = set.iterator().next();
        return first;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */