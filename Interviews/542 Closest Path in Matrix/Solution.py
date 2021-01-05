## DP 100%
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        dp = [[1000]*n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if (matrix[i][j] == 0):
                    dp[i][j] = 0
                else:
                    if i == 0 and j > 0: 
                        dp[i][j] = min(dp[i][j], dp[i][j-1]+1)
                    elif i > 0 and j == 0: 
                        dp[i][j] = min(dp[i][j], dp[i-1][j]+1)
                    elif i > 0 and j > 0: 
                        dp[i][j] = min(dp[i][j], dp[i-1][j]+1, dp[i][j-1]+1)

        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if matrix[i][j] != 0:  
                    if i == m-1 and j < n-1: 
                        dp[i][j] = min(dp[i][j], dp[i][j+1]+1)
                    elif i < m-1 and j == n-1: 
                        dp[i][j] = min(dp[i][j], dp[i+1][j]+1)
                    elif i < m-1 and j < n-1: 
                        dp[i][j] = min(dp[i][j], dp[i+1][j]+1, dp[i][j+1]+1)

        return dp
