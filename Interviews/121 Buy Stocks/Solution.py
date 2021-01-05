# My solution
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not len(prices): return 0
        res = 0
        
        for i in range(len(prices)-1):
            j = max(prices[i+1:])
            if j < prices[i]:
                continue
            else:
                res = max(res, j-prices[i])
        
        return res
        
# minprice, maxprice 
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        inf = int(1e9)
        minprice = inf
        maxprofit = 0
        for price in prices:
            maxprofit = max(price - minprice, maxprofit)
            minprice = min(price, minprice)
        return maxprofit
