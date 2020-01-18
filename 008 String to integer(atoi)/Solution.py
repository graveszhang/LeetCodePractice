class Solution:
    def myAtoi(self, str: str) -> int:
        flag = False
        signFlag = 0
        result = []
        for c in str:
            if (c == ' '): 
                if (result == [] and signFlag==0): continue
                else: break
            elif (c == '+' and result == []):
                flag = False
                signFlag += 1
            elif (c == '-' and result == []):
                flag = True
                signFlag += 1
            elif (c.isdigit()):
                result.append(int(c))
            else: break
        if (signFlag > 1): return 0
        
        times=1
        intResult = 0
        for i in reversed(result):
            intResult += i*times
            times*=10

        if flag: intResult = -1 * intResult

        if (intResult <= -2**31): return -2**31
        elif (intResult >= 2**31-1): return 2**31-1
        else: return intResult

