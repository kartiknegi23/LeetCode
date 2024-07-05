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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[2];
        ListNode temp = head.next;
        List<Integer> list = new ArrayList<>();
        int index = 1;
        ListNode prev = null;
        ListNode current = head;
        ListNode further;

        if(head.next!=null)
        further = current.next;

        else
        return new int[]{-1, -1};

        while(current!=null){
            if(prev!=null && current!=null && further!=null)
            if((prev.val < current.val && current.val > further.val) || (prev.val > current.val && current.val < further.val)){
                list.add(index);
            } 

            index++;
            prev=current;
            current=further;
            if(further!=null)
            further=further.next;
        }

        if(list.size()<=1)
        return new int[]{-1, -1};

        System.out.println(list);

        int previous = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            min = Math.min(min, list.get(i)-list.get(i-1));
        }

        result[0] = min;
        result[1] = list.get(list.size()-1)-list.get(0);

        return result;
    }
}