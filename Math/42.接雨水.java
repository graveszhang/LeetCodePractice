import java.util.Deque;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    /*
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++){
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) max_left = Math.max(max_left, height[j]);
            for (int j = i; j < size; j++) max_right = Math.max(max_right, height[j]);
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
    //  O(n^2)
    */
    /*
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        if (size == 0) return 0;
        int [] left = new int [size];
        int [] right = new int [size];
        left[0] = height[0];
        right[size - 1] = height[size - 1];
        for (int i = 1; i < size; i++) left[i] = Math.max(left[i-1], height[i]);
        for (int i = size - 2; i > 0; i--) right[i] = Math.max(right[i+1], height[i]);
        for (int i = 1; i < size - 1; i++) ans+= Math.min(left[i], right[i]) - height[i];
        return ans;
        // O(n) - trick is to save the info
        // Your runtime beats 99.87 % of java submissions
        // Your memory usage beats 48.96 % of java submissions (38.1 MB)
    }
    */

    public int trap(int[] height) {
        Deque<Integer> mono = new LinkedList<Integer>();
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            while (mono.isEmpty() == false && height[i] > height[mono.peek()]){
                int bottom = mono.pop();
                if (mono.isEmpty() == true) break;
                int width = i - mono.peek() - 1;
                int tall = Math.min(height[i], height[mono.peek()]) - height[bottom];
                ans += width*tall;
            }
            mono.push(i);
        }
        return ans;
    }
    // O(n) time and O(n) space, worth than last method though
    // 320/320 cases passed (2 ms)
    // Your runtime beats 50.97 % of java submissions
    // Your memory usage beats 21.05 % of java submissions (38.3 MB)
}
// @lc code=end

