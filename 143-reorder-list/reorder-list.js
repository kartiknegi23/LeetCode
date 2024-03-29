/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {

    let middle = head;
    let fast = head;

    while(fast!=null && fast.next!=null){
        middle=middle.next;
        fast=fast.next.next;
    }

    let prev = null;
    let current = middle.next;
    let nex;
    if(current!=null)
    nex = current.next;
    
    while(current!=null){
        current.next = prev;
        prev = current;
        current = nex;
        if(nex!=null)
        nex=nex.next;
    }

    middle.next = null;

    let head1 = head;
    let head2 = prev;




    while(head2!=null)
    {
        let temp1 = head1.next;
        let temp2 = head2.next;

        head1.next = head2;
        head2.next = temp1;

        head2 = temp2;
        head1 = temp1;

    }

    return head;
};