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
    let temp1 = node.next;
    let temp2 = node;

    while(temp1!=null){
        let t = node.val;
        node.val = temp1.val;
        temp1.val = t;

        node = node.next;
        temp1=temp1.next;
    }

    while(temp2.next!==node){
        temp2=temp2.next;
    }

    temp2.next=null;
};