#
# @lc app=leetcode id=5 lang=python3
#
# [5] Longest Palindromic Substring
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        head = 0
        tail = len(s)
        if (s[head:tail]==s[head:tail][::-1]):
            return s[head:tail]
        else: return self.longestPalindrome(s[head+1:tail]) or self.longestPalindrome(s[head:tail-1])

        
# @lc code=end

