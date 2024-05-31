/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    if(head===null)
    return null;

    let prev = null;
    let current = head;

    let upcoming = current.next;

    while(current!==null){
        current.next = prev;
        prev = current;
        current = upcoming;
        if(upcoming!==null)
        upcoming= upcoming.next;
    }    

    return prev;
};