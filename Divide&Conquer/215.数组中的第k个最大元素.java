import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Method 1
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        // Your runtime beats 90.39 % of java submissions
        // Your memory usage beats 40.29 % of java submissions (38.8 MB)

        // Method 2 
        // Incrementally Quick Sort & Select
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right){
        // Add randomness
        Random random = new Random();
        int r = random.nextInt(right - left + 1) + left;
        swap(nums, left, r);

        // Quick sort from left to right
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
// @lc code=end
