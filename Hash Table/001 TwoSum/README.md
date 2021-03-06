### Description

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

### Example

``````cpp
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
``````

### Ideas
1. 暴力法：遍历两遍   

   Time complexity: $O(n^2)$
   
   Space complexity: $O(1)$

2. 哈希表

   需要注意的是根据题目所求返回值为index，map的key设为num的值，而value设为num的index

   两种使用方法：
   
   - 先初始化hash table，再遍历一次找sum-num[i]，注意排除target=2num[i]情况

   - 初始化的同时向前寻找target-num[i]，不需要注意target=2num[i]


   Time complexity: $O(n)$

   Space complexity: $O(n)$
