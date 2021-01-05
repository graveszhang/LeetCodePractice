class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxx = dp[0];
        for (int i = 1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            maxx = Math.max(dp[i], maxx);
        }
        return maxx;
    }
}
// 由于dp[i]只和dp[i-1]有关 可以用一个变量记录 这样空间复杂度从O(N)降低到了O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
