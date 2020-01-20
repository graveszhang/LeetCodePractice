s = "mississippi"  # input(a-z)
p = "mis*is*ip*."  # pattern(a-z.*)
# test case

def regular_match(s, p):
    if (p == ".*"):
        return True

    sp = 0
    pp = 0

    while (sp < len(s)):
        if (pp == len(p)):
            return False
        if(s[sp] == p[pp]):
            if(pp < len(p)):
                sp += 1
                pp += 1
            else:
                sp += 1
                return False
        elif(p[pp] == '.'):
            if (pp+1 < len(p)):
                if (p[pp+1] == '*'):
                    return True
                else: p = p.replace(".", s[sp])
            else: p = p.replace(".", s[sp])
        elif(p[pp] == "*" and s[sp] == p[pp-1]):
            while (sp < len(s)):
                if (s[sp] == p[pp-1]):
                    sp += 1
                else:
                    break
            pp += 1
        else:
            if (pp+1 < len(p)):
                if (p[pp+1] == '*'):
                    pp += 2
                else:
                    return False
            else:
                return False

    return True


if __name__ == "__main__":
    if(regular_match(s, p)):
        print("True")
    else:
        print("False")
