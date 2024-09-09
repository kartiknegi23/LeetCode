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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        
        int id = 0;
        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;

        while(top<=down && left<=right){
            if(id==0){
                for(int i=left;i<=right;i++){
                    if(head!=null){
                        result[top][i] = head.val;
                        head = head.next; 
                    }
                    else{
                        result[top][i] = -1;
                    }
                }
                top++;
            }

            if(id==1){
                for(int i=top;i<=down;i++){
                    if(head!=null){
                        result[i][right] = head.val;
                        head = head.next;
                    }
                    else{
                        result[i][right] = -1;
                    }
                }
                right--;
            }

            if(id==2){
                for(int i=right;i>=left;i--){
                    if(head!=null){
                        result[down][i] = head.val;
                        head = head.next;
                    }
                    else{
                        result[down][i] = -1;
                    }
                }
                down--;
            }

            if(id==3){
                for(int i=down;i>=top;i--){
                    if(head!=null){
                        result[i][left] = head.val;
                        head = head.next;
                    }
                    else{
                        result[i][left] = -1;
                    }
                }
                left++;
            }

            id= (id+1)%4;

        }

        return result; 
    }

}