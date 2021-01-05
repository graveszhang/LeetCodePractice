class Solution:
    def reverseWords(self, s: str) -> str:
        result = ""
        for i in s.split()[::-1]:
            result = result + i + " "
        return result.rstrip()
