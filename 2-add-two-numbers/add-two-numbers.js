/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let carry = 0;
    let sum=0;
    let temp1 = l1;
    let temp2 = l2;

    let newnode = new ListNode();
    let head = newnode;

    if(temp1==null && temp2!==null)
    return temp2;

    else if(temp1!==null && temp2===null)
    return temp1;

    

    while(temp1!==null || temp2!==null || carry!==0){
        
        sum+=carry;
        if(temp1!=null){
            sum+=temp1.val;
            temp1 = temp1.next;

        }

        if(temp2!=null){
            sum+=temp2.val;
            temp2 = temp2.next;
        }


        carry = Math.floor(sum/10);
        sum = sum%10;
        

        newnode.val = sum;

        if(temp1===null && temp2===null && carry ===1){
            newnode.next = new ListNode(carry);
        }
        else if(temp1!==null || temp2!==null)
        newnode.next = new ListNode();
        
        newnode = newnode.next;

        sum = 0;

        
    }

    return head;
};