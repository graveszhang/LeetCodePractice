# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l2 == None: return l1
        if l1 == None: return l2
        head=ListNode(0);
        if (l1.val < l2.val): 
            head.next = l1
            l1 = l2
            l2 = head.next
        else: head.next = l2
        prev = head.next
        while l1 != None:
            flag = False
            while l2.val <= l1.val:
                if l2.next == None:
                    l2.next = l1
                    flag = True
                    break
                else:
                    prev = l2
                    l2 = l2.next
            if flag: break
            tmp = l1.next
            l1.next = l2
            prev.next = l1 
            prev = prev.next
            l1 = tmp 
        return head.next
    
class Solution:
    ### Recursion
    def mergeTwoLists(self, l1, l2):
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

