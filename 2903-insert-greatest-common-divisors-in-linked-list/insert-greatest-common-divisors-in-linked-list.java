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
    public int gcd(int a, int b){
        int min = Math.min(a,b);

        while(min>0){
            if(a%min==0 && b%min==0)
            return min;

            min--;
        }
        return 1;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null)
        return head;

        ListNode current = head;
        boolean now = true; 

        while(current!=null){
            if(now==true && current.next!=null){
                ListNode temp = new ListNode(gcd(current.val, current.next.val));
                temp.next = current.next;
                current.next = temp;
                now = false; 
            }
            else{
                now = true;
            }
            current = current.next;
        } 

        return head;
    }
}