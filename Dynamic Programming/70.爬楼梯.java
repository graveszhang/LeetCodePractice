/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int [] dp = new int [n+1];
        for (int i = 0; i<3; i++) dp[i] = i;
        for (int i = 3; i<n+1; i++) dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}
// @lc code=end

