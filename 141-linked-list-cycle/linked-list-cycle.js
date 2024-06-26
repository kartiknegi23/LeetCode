/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    let tortoise = head;
    let rabbit = head;

    while(rabbit!==null && rabbit.next!==null && tortoise!==null){
        tortoise = tortoise.next;
        rabbit = rabbit.next.next;

        if(rabbit===tortoise)
        return true;

    }

    return false;
};