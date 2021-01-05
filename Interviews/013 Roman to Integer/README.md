### Description
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

### Example
```
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
```
```
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

### Idea
- Use hash map to store the corresponing integer value for roman characters
- Find the relation of previous number and the current number, use the latter to minus the former one derives the result
