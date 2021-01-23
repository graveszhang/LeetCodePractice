import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount <= 0) return 0;
        
        int [] dp = new int [amount+1];
        for (int i = 0; i < amount+1; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) dp[coins[i]] = 1; // or dp[0] = 0 二选一 必须初始化
        }
        for (int i = 1; i < amount+1; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i && dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
// @lc code=end

