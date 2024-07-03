class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, DoubleLinkedList> freqmap;
    int capacity_;
    int current_size;
    int min_frequency;
    public LFUCache(int capacity) {
        this.capacity_ = capacity;
        this.current_size = 0;
        this.min_frequency = 0;
        this.cache = new HashMap<>();
        this.freqmap = new HashMap<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            update(node);
            return node.value;
        }

        else
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity_ == 0) 
        return;

        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            update(node);
        }

        else{
            if(current_size == capacity_){
                DoubleLinkedList list = freqmap.get(min_frequency);
                cache.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
                current_size -=1;
            }
            min_frequency = 1;
            Node newnode = new Node(key, value);
            DoubleLinkedList list = freqmap.getOrDefault(1, new DoubleLinkedList());
            list.addnode(newnode);
            freqmap.put(1, list);
            cache.put(key, newnode);
            current_size++;
        }
    }

    public void update(Node node){
        int frequency = node.frequency;
        DoubleLinkedList list = freqmap.get(frequency);
        list.remove(node);

        if(frequency==min_frequency && list.listsize==0){
            min_frequency++;
        }

        node.frequency++;
        System.out.println(node.frequency);
        DoubleLinkedList newlist = freqmap.getOrDefault(node.frequency, new DoubleLinkedList());
        newlist.addnode(node); 
        freqmap.put(node.frequency, newlist);
    }

    class Node{
        int key,value;
        Node prev,next;
        int frequency;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.frequency=1;
        }
    }

    class DoubleLinkedList{
        Node head;
        Node tail;
        int listsize;

        public DoubleLinkedList(){
            listsize = 0;
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addnode(Node node){
            Node headnext = head.next;
            head.next = node;
            node.prev = head;
            node.next = headnext;
            headnext.prev = node;
            listsize++;
        }

        public void remove(Node node){
            Node prevnode = node.prev;
            Node nextnode = node.next;
            prevnode.next = nextnode;
            nextnode.prev = prevnode;
            listsize--;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */