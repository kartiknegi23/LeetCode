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
var removeNodes = function(head) {
    let stack = [];

    let temp = head;

    while(temp!=null){
        while(stack.length>0 && stack[stack.length-1].val<temp.val){
            stack.pop();
        }

        stack.push(temp);
        temp=temp.next;
    }


    let dummy = new ListNode(0,head);
    let prev = dummy; 

    for(node of stack){
        if(prev!=null)
        {
        prev.next = node;
        prev = prev.next;}
    }

    if(prev!=null)
    prev.next = null

    if(dummy!=null)
    return dummy.next;
};