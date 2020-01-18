def myAtoi(str: str) -> int:
    flag = False
    result = []
    for c in str:
        if (c == ' '):
            continue
        elif (c == '-'):
            flag = True
        elif (c.isdigit()):
            result.append(int(c))
        else:
            if(result==[]): return 0
            else: continue
    
    times=1
    intResult = 0
    for i in reversed(result):
        intResult += i*times
        times*=10
    
    if flag: intResult = -1 * intResult
    
    if (intResult <= -2**31): return -2**31
    elif (intResult >= 2**32-1): return 2**32-1
    else: return intResult

if (__name__ == "__main__"):
    str="-123 dsa"
    print(myAtoi(str))

