class Solution:
    def romanToInt(self, s: str) -> int:
        mapping = {
            "I":1,
            "V":5,
            "X":10,
            "L":50,
            "C":100,
            "D":500,
            "M":1000
        }
        result = 0
        prev = 0
        for c in reversed(s):
            a = mapping.get(c)
            if a < prev:
                result -= a
            else:
                result += a
                prev = a
        return result
