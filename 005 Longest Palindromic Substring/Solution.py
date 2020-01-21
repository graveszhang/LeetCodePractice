class Solution:
    def longestPalindrome(self, s: str) -> str:
        head = 0
        tail = len(s)
        if (s[head:tail]==s[tail:head:-1]):
            return s[head:tail]
        else: 
          return self.longestPalindrome(s[head+1:tail]) or self.longestPalindrome(s[head:tail-1])
