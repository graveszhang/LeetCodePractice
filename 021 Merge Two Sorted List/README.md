### Description
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

### Example
```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

### Idea
递归merge函数:每次在两个链表中找到更小的那个值进行返回，让他指向除这个元素以外的所有元素的merge()，最终指向null即可。
