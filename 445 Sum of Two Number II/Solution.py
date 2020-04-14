# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        num1, num2 = "",""
        Ans = ans = ListNode(0)
        while (l1 != None):
            num1 += str(l1.val)
            l1 = l1.next
        while (l2 != None):
            num2 += str(l2.val)
            l2 = l2.next
        result = str(int(num1)+int(num2))
        for i in result:
            ans.next = ListNode(int(i))
            ans = ans.next
        return Ans.next
