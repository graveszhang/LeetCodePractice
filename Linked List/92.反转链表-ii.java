/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (n == m) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int curr = 1;
        ListNode headcp = head;
        ListNode start = null;
        ListNode then = null;
        ListNode pre = dummy;
        // System.out.println(head.val);
        while (curr != m){
            pre = headcp;
            headcp = headcp.next;
            curr++;
        }
        start = pre.next;
        System.out.println(start.val);
        then = start.next;
        System.out.println(then.val);

        for(int i = 0; i < n - m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
// @lc code=end

