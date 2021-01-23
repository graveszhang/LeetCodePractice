/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        return mergesort(head, null);
    }

    public ListNode mergesort(ListNode left, ListNode right){
        if (left == null) return left;
        if (left.next == right) {
            left.next = null;
            return left;
        }
        ListNode slow = left, fast = left;
        while (fast != right){
            fast = fast.next;
            slow = slow.next;
            if (fast != right) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode first = mergesort(left, mid), second = mergesort(mid, right);
        ListNode sorted = merge(first, second);
        return sorted;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyhead = new ListNode(-1);
        ListNode head = dummyhead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return dummyhead.next;
    }
}
// @lc code=end

