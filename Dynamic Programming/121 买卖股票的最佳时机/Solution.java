class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minbuy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length;i++){
            minbuy = Math.min(minbuy, prices[i]);
            profit = Math.max(profit, prices[i]-minbuy);
        }
        return profit;
    }
}
// 一次遍历 复杂度O(n)
