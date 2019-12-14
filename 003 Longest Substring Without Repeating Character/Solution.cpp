class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int left=0;
        int right=1;
        int length=0;
        while (right<s.length()+1){
            for (int i=left; i<right; i++){
                if (s[i]==s[right]){
                    if (right-left>length){
                        length=right-left;
                    }
                    left=i+1;
                }
            }
            if (right-left>length){
                length=right-left;
            }
            right++;                     
        }
        return length;                         
    }                           
};

// 执行用时 : 24 ms, 在所有 cpp 提交中击败了 55.02% 的用户
// 内存消耗 : 9.1 MB, 在所有 cpp 提交中击败了 90.39% 的用户
