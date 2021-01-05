import re
class Solution:
    def myAtoi(self, str: str) -> int:
	if not re.findall('^\s*([-+]?[0-9]+)',str):
            return 0
        else: intResult = int(re.findall('^\s*([-+]?[0-9]+)',str)[0])
		if (intResult <= -2**31): return -2**31
        elif (intResult >= 2**31-1): return 2**31-1
        else: return intResult
