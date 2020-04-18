class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not len(prices): return 0
        dp = [0 for i in range(len(prices))] # dp[i] 表示第i天获得的最大利润
        
        for i in range(len(prices)-1):
            if prices[i+1] > prices[i]:
                dp[i+1] = max(dp[i] + prices[i+1] - prices[i], dp[i+1])
            else:
                dp[i+1] = max(dp[i], dp[i+1])
        
        return dp[len(prices)-1]
