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
var doubleIt = function(head) {
    let arr = [];
    let temp = head;
    let len = 0;
    let carry = 0;

    while(temp!=null){
        arr.push(temp.val);
        temp=temp.next;
        len++;
    }

    
    for(let i=arr.length-1;i>=0;i--){
        if(arr[i]>=5){
            arr[i]=((arr[i]*2))%10+carry;
            carry = 1;
        }
        else{
            arr[i]=arr[i]*2+carry;
            carry=0;
        }
    }

    let current = head;
    let node = new ListNode(1);
    if(carry===1){
        
        node.next=current;
    }

    let i=0;
    while(current!=null){
        current.val= arr[i];
        i++;
        current=current.next;
    }

    if(carry===1)
    return node;
    
    else
    return head;
};