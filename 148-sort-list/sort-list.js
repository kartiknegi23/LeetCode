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
var sortList = function(head) {
    let stack = [];
    let temp = head;

    if(temp===null)
    return temp;

    while(temp!==null){
        stack.push(temp.val);
        temp=temp.next;
    }

    stack.sort((a,b)=>a-b);
    temp = head;
    let i=0;

    while(temp!==null){
        temp.val = stack[i];
        i++;
        temp=temp.next;
    }
    return head;
};