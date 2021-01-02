// dp
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int k = 0; k < n; ++k){
            for (int i = 0; i + k < n; ++i){
                int j = i + k;
                if (k == 0) {
                    // string of length 1 always true 
                    dp[i][j] = true;
                } else if (k == 1) {
                    // string of length 2 is true when two char are identical
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    // cut off two side letter and compare the rest
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && k + 1 > res.length()) {
                    res = s.substring(i, i + 1 + k);
                }
            }
        }
        return res;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        int max = -1;
        String res = "";
        for (int i = 0; i < n - 1; i++){
            String odd = centerSpread(s, i, i);
            String even = centerSpread(s, i, i + 1);
            String maxstr = odd.length() > even.length() ? odd : even;
            if (maxstr.length() > maxLen) {
                maxLen = maxstr.length();
                res = maxstr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
