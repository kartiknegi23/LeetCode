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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = new ListNode();
        ListNode temp = head.next;
        ListNode prev = node;
        int sum = 0;
        while(temp!=null){
            if(temp.val==0)
            {   
                ListNode newnode = new ListNode(sum);
                prev.next = newnode;
                prev = newnode;
                sum=0;
            }

            else
            sum+=temp.val;

            temp=temp.next;
        }
        return node.next;
    }
}