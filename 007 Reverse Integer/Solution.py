def reverse():
    if (x==0): return x
    result = ""
    x = str(x)
    a = len(x)
    flag = False
    if(x[a-1] == '0'):
        x = x[0:a-1]
    if(x[0] == '-'):
        x = x[1:len(x)]
        flag = True

    for i in reversed(x):
        result += i
    result = int(result)

    if flag:
        result = -1 * result

    if(result < 2147483648 and result >= -2147483648):
        return result
    else: return 0


if __name__ == "__main__":
    a = reverse()
    print(a)
