/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 */
var deleteNode = function(node) {
    let temp = node;
    let secondlast = temp.next;

    while(temp.next!==null)
    {
    let ele = temp.val;
    temp.val = temp.next.val;
    temp.next.val = ele;

    if(secondlast.next===null){
        temp.next=null;
        break;
    }

    temp=temp.next;
    secondlast = secondlast.next;
    }

};