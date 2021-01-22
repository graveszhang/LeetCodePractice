/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int ans = 0;
    int width;
    int height;

    public int numIslands(char[][] grid) {
        width = grid.length;
        if (width == 0) return ans;
        height = grid[0].length;

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= width || j >= height || grid[i][j] == '0') 
            return;
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
// @lc code=end

