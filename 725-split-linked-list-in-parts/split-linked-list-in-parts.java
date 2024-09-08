/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }

        int parts = len/k;
        int fraction = len%k;

        ListNode[] result = new ListNode[k];
        ListNode current = head;
        int count = 0;

        ListNode newHead = head;
        int length = parts;
        int index = 0;
        if(fraction>0){
            length++;
            fraction--;
        }
        while(current!=null){
            count++;
            if(count==length){
                
                if(current.next!=null){
                    ListNode tempNode = current.next;
                    current.next = null;
                    result[index] = newHead;
                    index++;
                    newHead = tempNode;
                    current = tempNode;

                    count=0;
                    length = parts;
                    if(fraction>0){
                        length++;
                        fraction--;
                    }
                }
                else{
                    result[index] = newHead;
                    index++;
                }
            
            }
            else{
                current = current.next;
            }
        }

        return result;
    }
}