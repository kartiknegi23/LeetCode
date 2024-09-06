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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        ListNode current=head;
        ListNode prev = null;

        while(current!=null){
            if(set.contains(current.val) && current==head){
                prev = current;
                current = current.next;
                head = current;
            }

            else if(set.contains(current.val)){
                prev.next = current.next;
                current.next = null;
                current = prev.next; 
            }
            else{
                prev=current;
                current=current.next;
            }
        }

        return head;
    }
}