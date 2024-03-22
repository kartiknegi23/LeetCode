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
    let slow = head;
    let temp = head;
    let fast = head;

    while(slow!=null && fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }


    let prev = null;
    let nex = null;
    let current = slow;

    if(current!=null)
    nex = current.next;


    while(current!=null){
        current.next= prev;
        prev = current;

        current = nex;
        
        if(nex!=null)
        nex = nex.next;
        
    }


    while(temp!=null && prev!=null){
        if(temp.val != prev.val)
        return false;

        temp=temp.next;
        prev=prev.next;
    } 
    return true;
};