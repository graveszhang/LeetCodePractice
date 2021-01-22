import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, n, n, "");
        return res;
    }

    public void helper(List<String> res, int left, int right, String tmp){
        if (left == 0 && right == 0) {
            res.add(tmp);
            return;
        }
        if (left > right) return;
        if (left > 0) {
            helper(res, left - 1, right, tmp + "(");
        }

        if (right > 0) {
            helper(res, left, right - 1, tmp + ")");
        }
    }
}
// @lc code=end

