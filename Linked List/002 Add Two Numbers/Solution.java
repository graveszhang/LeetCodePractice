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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode tail = null;
        int flag = 1; // initialization
        int sum = -1;
        int carry = 0;

        while (l1 != null || l2 != null){
            int n1 = l1!=null ? l1.val : 0;
            int n2 = l2!=null ? l2.val : 0;
            sum = n1 + n2 + carry; 
            if (sum >= 10) carry = 1;
            else carry = 0;
            
            if (flag == 1) {
                res = tail = new ListNode(sum%10);
                flag = 0;
            }
            else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) tail.next = new ListNode(carry);   
        return res;
    }
}
