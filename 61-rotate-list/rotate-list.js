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
var rotateRight = function(head, k) {

    if(head===null)
    return head;

    if(head.next==null)
    return head;

    let length=0;
    let temp = head;

    while(temp!==null){
        length++;
        temp=temp.next;
    }

    k = k%length;

    if(k===0)
    return head;

    let count = 0;

    while(count<k){
        let current = head;
        let prev = null;
        while(current.next!==null){
            prev = current;
            current = current.next;
        }
        current.next = head;
        prev.next = null;
        head = current;

        count++;
    }
    return head;
};