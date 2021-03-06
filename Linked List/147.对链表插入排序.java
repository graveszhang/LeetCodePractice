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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head; 
        ListNode curr = head.next; 
        while(curr != null){
            if (curr.val < prev.val){
                ListNode tmp = dummy;
                while (tmp.next.val < curr.val){
                    tmp = tmp.next;
                }
                prev.next = curr.next;
                curr.next = tmp.next; // 我不太理解为什么不能指向prev
                tmp.next = curr;
                curr = prev.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
