/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    let stack = [];
    let temp = head;

    if(temp===null)
    return false;

    while(temp!==null){
        stack.push(temp.val);
        temp=temp.next;
    }

    temp = head;

    while(temp!=null){
        if(temp.val !== stack[stack.length-1])
        return false;

        else
        stack.pop();

        temp=temp.next;
    }

    return true;
};