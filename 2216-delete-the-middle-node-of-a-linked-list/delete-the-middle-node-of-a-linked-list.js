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
var deleteMiddle = function(head) {
    let length = 0;
    let temp = head;
    while(temp!==null){
        length++;
        temp=temp.next;
    }

    let index = Math.floor(length/2);

    if(index===0)
    {
        head=head.next;
        return head;
    }

    let count = 0;
    temp = head;

    while(temp!==null){
        if(count===(index-1)){
            let temp_node = temp.next;
            if(temp_node!==null)
            {
                temp.next = temp_node.next;
                temp_node.next = null;
            }
            break;
        }
        else{
            temp=temp.next;
            count++;
        }
    }
    return head;
};