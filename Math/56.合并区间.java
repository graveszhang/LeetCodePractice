import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

// Arraylist 长度可变 int [] 不能变

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int [] curr = intervals[0];
        for (int i = 0; i < intervals.length; i++){
            if (curr[1] >= intervals[i][0]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

