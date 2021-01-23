import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        int rowbegin = 0, rowend = m - 1, 
            colbegin = 0, colend = n - 1;
        while (rowbegin <= rowend && colbegin <= colend) {
            for (int i = colbegin; i <= colend; ++i){
                ans.add(matrix[rowbegin][i]);
            }
            rowbegin++;
            for (int i = rowbegin; i <= rowend; ++i){
                ans.add(matrix[i][colend]);
            }
            colend--;
            
            if (rowbegin > rowend || colbegin > colend) break; //duplicate occurs

            for (int j = colend; j >= colbegin; j --) {
                ans.add(matrix[rowend][j]);
            }
            rowend--;

            for (int j = rowend; j >= rowbegin; j --) {
                ans.add(matrix[j][colbegin]);
            }
            colbegin++;

        }
        return ans;
    }
}
// @lc code=end

