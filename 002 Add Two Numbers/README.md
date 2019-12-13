### Description

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Example

```cpp
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

### Ideas

对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。

这道题里基本上所有的结果都是保存在next指针下的，这样做的好处是便于直接new一个可以初始化的节点。如果把结果存在当前位，要找到下一个节点需要
```result->next = new ListNode(1);```
```result=result->next;```
这样做难以处理链表的最后一位，如果直接把结果存在下一位，可以保证每一个new的下一位都会被用作结果而不需要删除。

关于进位问题，需要注意的是每个```addone```项（上一位）需要被放入每一位的计算中，而最后的进位项需要额外new一个值为1的node
