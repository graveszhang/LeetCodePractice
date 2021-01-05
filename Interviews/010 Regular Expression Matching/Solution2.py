class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        import re
        return bool(re.match('^' + p + '$', s))
# regex match
