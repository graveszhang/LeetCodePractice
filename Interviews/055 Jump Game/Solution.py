class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if (len(nums) == 0):
            return True
        dp = [False for i in range(len(nums))] # dp[i] 表示当前能否被跳到
        dp[0] = True
        for i in range(1,len(nums)):
            for j in range(i):
                if (nums[i-1-j] > j and dp[i-1-j]):
                    dp[i] = True
                    break

        return dp[len(nums)-1]
