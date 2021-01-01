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
