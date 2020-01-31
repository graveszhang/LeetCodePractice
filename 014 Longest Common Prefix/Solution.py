class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs: return ""
        if len(strs)==1: return strs[0]
        minlen = 1000 # to mark a minimum length among strs
        for i in strs:
            minlen = min(len(i),minlen) 
            if not i: 
                return "" 
        common = ""
        pt = 0
        while (pt<minlen):
            common += strs[0][pt]
            for i in strs:
                if (common == i[:pt+1:]):
                    continue
                else:
                    return common[:pt:]
            pt += 1
        return common
