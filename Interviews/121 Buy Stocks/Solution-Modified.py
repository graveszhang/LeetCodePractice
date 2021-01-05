## 一开始看错题了
## 这个解法是不限制交易次数获得的最大收益
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not len(prices): return 0
        dp = [0 for i in range(len(prices))] # dp[i] 表示第i天获得的最大利润
        
        for i in range(len(prices)-1):
            for j in range(i+1, len(prices)):
                if prices[j] > prices[i]:
                    dp[j] = max(dp[i-1] + prices[j] - prices[i], dp[j])
                else:
                    dp[j] = max(dp[i], dp[j])
        
        return dp[len(prices)-1]
