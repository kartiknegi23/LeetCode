/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */

function find(temp, k){
    let start = temp;
    let count = 1;

    while(start!==null){
        if(count===k)
        return start;

        count++;
        start = start.next;
    }
    return start;
}

function reverse(temp){
    let prev = null;
    let current = temp;
    let following = temp.next;

    while(current!==null){
        current.next = prev;
        prev = current;
        current = following;
        if(following!==null)
        following = following.next;
    }
}

var reverseKGroup = function(head, k) {
    if(head===null)
    return head;
    
    let temp = head;
    let prev_node = null;

    while(temp!==null){
        let kth_node = find(temp,k);
        if(kth_node===null){
            if(temp===head)
            return head;

            else
            prev_node.next = temp;
            break;
        }

        let next_node = kth_node.next;
        kth_node.next = null;

        reverse(temp);

        if(temp===head)
        head = kth_node;

        else
        prev_node.next = kth_node;

        prev_node = temp;
        temp = next_node;


    }

    return head;
};