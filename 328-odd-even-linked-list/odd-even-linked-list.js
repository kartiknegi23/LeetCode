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
var oddEvenList = function(head) {

    if(head===null)
    return head;

    let odd_temp  = head;
    let even_temp = head.next;
    let even_head = even_temp;

    while(even_temp!=null && odd_temp!==null){
        if(odd_temp.next!==null && odd_temp.next.next!==null)
        {
            odd_temp.next = odd_temp.next.next;
            odd_temp = odd_temp.next;
        }

        if(even_temp.next!==null)
        {
            even_temp.next = even_temp.next.next;
            even_temp = even_temp.next;
        }

        else
        break;
    }

    if(odd_temp!==null)
    odd_temp.next = even_head;

    return head;
};