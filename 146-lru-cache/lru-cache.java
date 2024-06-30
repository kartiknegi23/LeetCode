class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity_;
    Map<Integer, Node> hashmap = new HashMap<>();

    public LRUCache(int capacity) {
        capacity_ = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hashmap.containsKey(key)){
            Node node = hashmap.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else
        return -1;
    }
    
    public void put(int key, int value) {
        if(hashmap.containsKey(key)){
            remove(hashmap.get(key));
        }

        if(hashmap.size()==capacity_){
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    public void remove(Node node){
        hashmap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev; 
    }

    public void insert(Node node){
        hashmap.put(node.key, node);
        Node headnext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headnext;
        headnext.prev = node;
    }
}

class Node{
    Node prev, next;
    int key;
    int value;
    public Node(int _key, int _value){
        key = _key;
        value = _value;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */