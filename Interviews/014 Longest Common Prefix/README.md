### Description
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

### Example
```
Input: ["flower","flow","flight"]
Output: "fl"
```
```
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

### Ideas
- strs[a:b:] only covers string from index a to b-1
