# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = l2
        while l1 != None:
            while l2.next.val <= l1.val:
                l2 = l2.next
            l1.next = l2.next
            l2.next = l1 
            l1 = l1.next
        return head

#### Not Passed --> Time Limited Err

