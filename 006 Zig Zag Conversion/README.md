### Description
The string ```"PAYPALISHIRING"``` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
```
P   A   H   N
A P L S I I G
Y   I   R
```
And then read line by line: ```"PAHNAPLSIIGYIR"```

Write the code that will take a string and make this conversion given a number of rows:

```string convert(string s, int numRows);```

### Example
```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
```
### Ideas
- Create a 2D list that each row of the list is another list, use step and row to navigate through the 2D list.
- Whenever row = rowNum-1, make step = -1 until reach row = 1.
- Use str.join() to append list to str

### Result
- Runtime: 60 ms, faster than 61.72% of Python3 online submissions for ZigZag Conversion.
- Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for ZigZag Conversion.
