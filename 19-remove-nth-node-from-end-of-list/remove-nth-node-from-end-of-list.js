/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let length = 0;
    let temp = head;

    while(temp!==null){
        length++;
        temp=temp.next;
    }

    let counter = length-n;

    if(counter===0 && length===1)
    return null;

    count = 1;
    temp = head;

    while(temp!==null){

        if(counter===0)
        {
            head=head.next;
            break;
        }

        if(count===counter){
            let temp_node = temp.next;
            if(temp_node!==null)
            temp.next = temp_node.next;
            break; 
        }
        else
        temp=temp.next;
        count++;
    }
    return head;
};