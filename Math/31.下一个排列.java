/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (nums == null || n <= 1) return;
        int curr = -1;
        for (int i = 0; i < n-1; i++){
            if (nums[i] < nums[i+1]) {
                curr = i; 
            }
        }
        if (curr == -1){
            Arrays.sort(nums);
            return;
        } else {
            int j = n - 1;
            while (nums[j] <= nums[curr]){
                j--;
            }
            swap(nums, curr, j);
        }
        // curr+1 到 n-1 一定是降序 直接重排
        reverse(nums, curr + 1, n - 1);
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
    
}
// @lc code=end

