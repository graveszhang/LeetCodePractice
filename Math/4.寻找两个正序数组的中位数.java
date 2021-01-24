import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int [] sort =  new int [m + n];
        MergeSortedArrays(sort, nums1, nums2, m, n);
        int l = sort.length;
        // for (int i = 0; i < l; ++i) System.out.println(sort[i]);
        if (l%2 == 0) return (float)(sort[l/2]+sort[l/2-1])/2;
        return sort[l/2];
    }

    public void MergeSortedArrays(int [] sort, int[] nums1, int[] nums2, int m, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0))
            sort[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        if (p1 > 0)
            System.arraycopy(nums1, 0, sort, 0, p+1);
        if (p2 > 0)
            System.arraycopy(nums2, 0, sort, 0, p+1);
    }
}
// @lc code=end

