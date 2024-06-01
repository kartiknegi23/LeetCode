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
    
    let stack = [];
    let odd = head;
    let even = head.next;
    

    while(odd!==null){
        stack.push(odd.val);
        if(odd.next!==null)
        odd=odd.next.next;
        else
        break;
    }

    while(even!==null){
        stack.push(even.val);

        if(even.next!==null)
        even=even.next.next;
        else
        break
    }

    let temp = head;
    let i = 0;
    while(temp!==null){
        temp.val = stack[i];
        i++;
        temp=temp.next;
    }
    return head;
};