/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    let temp = head;
    if(temp===null)
    return temp;

    let hashmap = new Map();

    hashmap.set(temp, 1);

    while(temp!=null){
        temp=temp.next;

        if(temp!==null)
        {if(hashmap.has(temp))
        return temp;

        else
        hashmap.set(temp, 1);}
    }
    
    return null;
};