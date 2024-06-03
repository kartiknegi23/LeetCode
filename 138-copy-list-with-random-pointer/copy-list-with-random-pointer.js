/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function (head) {

    if (head === null)
        return head;


    let hashmap = new Map();

    let temp = head;
    let new_head = new Node(temp.val);
    let new_node = new_head;
    hashmap.set(temp, new_node);

    temp = temp.next;
    

    while (temp!==null) {
        let next_node = new Node(temp.val);

        new_node.next = next_node;
        new_node = next_node;

        hashmap.set(temp, new_node);

        temp = temp.next;
    }

    let current = new_head;
    temp = head;

    while(current!==null){
        current.random = hashmap.get(temp.random);
        temp = temp.next;
        current = current.next;
    }

    return new_head;
};