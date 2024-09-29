class AllOne {
    
    Map<String, Node> hashmap; 
    Node head;
    Node last;

    void addNode(Node currentNode, int frequency){
        Node newNode = new Node(frequency);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        newNode.prev = currentNode;
        if(newNode.next!=null)
        newNode.next.prev = newNode;

        if(currentNode==last)
        last = newNode;

    }

    void removeNode(Node currentNode){
        currentNode.prev.next = currentNode.next;
        if(currentNode.next!=null){
            currentNode.next.prev = currentNode.prev;
        }
        if(currentNode==last)
        last = currentNode.prev;

    }

    public AllOne() {
        hashmap = new HashMap<>();
        head = new Node(0);
        last = head;
    }
    
    public void inc(String key) {
        if(!(hashmap.containsKey(key))){
            if(head.next==null || head.next.count!=1){
                addNode(head, 1);
            }
            head.next.set.add(key);
            hashmap.put(key, head.next);
        }
        else{
            Node current_node = hashmap.get(key);
            int current_count = current_node.count;
            if(current_node.next==null || current_node.next.count != current_count+1){
                addNode(current_node, current_count+1);
            }
            current_node.next.set.add(key);
            hashmap.put(key, current_node.next);
            current_node.set.remove(key);
            if(current_node.set.size()==0){
                removeNode(current_node);
            }
        }
    }
    
    public void dec(String key) {
        Node current_node = hashmap.get(key);
        int current_count = current_node.count;

        if(current_count==1){
            hashmap.remove(key);
        }
        else{
            if(current_node.prev.count!=current_count-1){
                addNode(current_node.prev, current_count-1);
            }
            current_node.prev.set.add(key);
            hashmap.put(key, current_node.prev);
        }
        current_node.set.remove(key);
        if(current_node.set.size()==0){
            removeNode(current_node);
        }
    }
    
    public String getMaxKey() {
        if(last==head)
        return "";

        Set<String> max = last.set;
        Iterator<String> iterator = max.iterator();
        return iterator.next();        
    }
    
    public String getMinKey() {
        if(last==head)
        return "";

        Set<String> min = head.next.set;
        Iterator<String> iterator = min.iterator();
        return iterator.next();
    }
}

class Node{
        Node prev;
        Node next;
        Set<String> set = new HashSet<>();
        int count;

        Node(int k){
            count = k;
            next=null;
            prev=null;
        }  
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */