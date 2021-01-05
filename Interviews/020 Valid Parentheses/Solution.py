class Solution:
    def isValid(self, s: str) -> bool:
        if not s: return True
        if (len(s)%2==1): return False
        if s[0] == ")" or s[0] == "]" or s[0] == "}": return False
        queue = []
        for i in s:
            queue.append(i)
            pos = len(queue)-1
            if i == ")":
                if queue[pos-1] == "(":
                    queue.pop()
                    queue.pop()
                else:
                    return False
            elif i == "]":
                if queue[pos-1] == "[":
                    queue.pop()
                    queue.pop()
                else:
                    return False
            elif i == "}":
                if queue[pos-1] == "{":
                    queue.pop()
                    queue.pop()
                else:
                    return False 
        if len(queue) == 0:
            return True      
        else: return False
