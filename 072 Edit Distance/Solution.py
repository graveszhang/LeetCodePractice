class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        l1 = len(word1)
        l2 = len(word2)
        
        if l1*l2 == 0:
            return l1+l2

        dp = [ [0] * (l2+1) for _ in range(l1+1)]

        for i in range(l1+1):
            dp[i][0] = i

        for j in range(l2+1):
            dp[0][j] = j

        for i in range(1,l1+1):
            for j in range(1,l2+1):
                if word1[i-1] == word2[j-1]:
                    # dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]-1)+1
                    # 这步可以优化成下面
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
        
        return dp[l1][l2]
