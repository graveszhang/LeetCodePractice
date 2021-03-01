class Solution {
    public int minDistance(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();

        if (a == 0 || b == 0) return a+b;
        int[][] dp = new int [a+1][b+1];

        for (int i = 0; i < a+1; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j < b+1; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i < a + 1; i++){
            for (int j = 1; j < b + 1;j++){
                int tmp1 = dp[i-1][j] + 1;
                int tmp2 = dp[i][j-1] + 1;
                int tmp3 = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) tmp3+=1;
                dp[i][j] = Math.min(tmp1, Math.min(tmp2, tmp3));
            }
        }
        return dp[a][b];
    }
}

