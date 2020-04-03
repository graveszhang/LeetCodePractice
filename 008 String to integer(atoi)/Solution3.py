class Solution:
    def myAtoi(self, str: str) -> int:
        INT_MAX = 2**31-1
        INT_MIN = -2**31
        num = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
        myint = []
        result = 0
        flag = True # True = pos, False = neg
        flagflag = False # Flag for pos/neg change
        intflag = False # start count int
        if str:
            for i in str:
                if (i == ' '):
                    if not intflag:
                        continue
                    else:
                        break
                if (i == '-'):
                    if not flagflag and not intflag:
                        flag = False
                        flagflag = True
                        intflag = True
                        continue
                    else:
                        break
                if (i == '+'):
                    if not flagflag and not intflag:
                        flagflag = True
                        intflag = True
                        continue
                    else:
                        break
                if (i in num):
                    myint.append(int(i))
                    intflag = True
                else:
                    break
        else:
            return 0

        intlen = len(myint)

        if (intlen == 0):
            return 0
        else:
            j = 0
            for i in myint:
                result += i*10**(intlen-1-j)
                j += 1
        
        if not flag:
            result = -result

        if result >= INT_MAX:
            return INT_MAX
        if result <= INT_MIN:
            return INT_MIN

        return result
