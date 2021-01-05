class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
    while (head != null) {
        stack.push(head);
        head = head.next;
    }
    if (stack.isEmpty())
        return null;
    ListNode node = stack.pop();
    ListNode dummy = node;
    while (!stack.isEmpty()) {
        ListNode tempNode = stack.pop();
        node.next = tempNode;
        node = node.next;
    }
    node.next = null;
    return dummy;
}
