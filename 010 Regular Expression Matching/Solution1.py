s = "aaa"  # input(a-z)
p = "ab*a*c*a"  # pattern(a-z.*)
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
                    if (pp+2 < len(p)):
                        if (p[pp+2] in s):
                            sp = s.find(p[pp+2], sp)
                        else:
                            return False
                    else:
                        return True
                else:
                    p = p.replace(".", s[sp])
            else:
                p = p.replace(".", s[sp])
        elif(p[pp] == "*" and s[sp] == p[pp-1]):
            while (sp < len(s)):
                if (s[sp] == p[pp-1]):
                    sp += 1
                else:
                    break
            pp += 1
            if (pp < len(p)):
                if (sp == len(s)):
                    if (p[pp] == s[sp-1]):
                        pp += 1
                    else:
                        return False
        else:
            if (pp+1 < len(p)):
                if (p[pp+1] == '*'):
                    pp += 2
                else:
                    return False
            else:
                return False

    if(pp >= len(p)):
        return True
    else:
        return False


if __name__ == "__main__":
    if(regular_match(s, p)):
        print("True")
    else:
        print("False")
