## Google

# 这里的状态量是n个蛋m步操作可以确认多少层楼
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        if N == 1:
            return 1
        f = [[0] * (K + 1) for _ in range(N + 1)]
        for i in range(1, K + 1):
            f[1][i] = 1
        ans = -1
        for i in range(2, N + 1):
            for j in range(1, K + 1):
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j]
            if f[i][K] >= N:
                ans = i
                break

# 这里的状态量是k个蛋n层楼最少需要多少步
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        memo = {}
        def dp(k, n):
            if (k, n) not in memo:
                if n == 0:
                    ans = 0
                elif k == 1:
                    ans = n
                else:
                    lo, hi = 1, n
                    # keep a gap of 2 X values to manually check later
                    while lo + 1 < hi:
                        x = (lo + hi) // 2
                        t1 = dp(k-1, x-1)
                        t2 = dp(k, n-x)

                        if t1 < t2:
                            lo = x
                        elif t1 > t2:
                            hi = x
                        else:
                            lo = hi = x

                    ans = 1 + min(max(dp(k-1, x-1), dp(k, n-x))
                                  for x in (lo, hi))

                memo[k, n] = ans
            return memo[k, n]

        return dp(K, N)
