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
        int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
        // 不分奇偶情况直接返回中位数
    }
    
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        // i: nums1的起始位置 
        // j: nums2的起始位置
        if( i >= nums1.length) return nums2[j + k - 1]; // nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1]; // nums2为空数组
        if(k == 1) return Math.min(nums1[i], nums2[j]);
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        return midVal1 < midVal2 ? findKth(nums1, i + k / 2, nums2, j , k - k / 2) : 
                                   findKth(nums1, i, nums2, j + k / 2 , k - k / 2) ;
    }
    // O(log(m+n))
    // 2091/2091 cases passed (3 ms)
    // Your runtime beats 82.47 % of java submissions
    // Your memory usage beats 24.97 % of java submissions (39.9 MB)

    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int [] sort =  new int [m + n];
        MergeSortedArrays(sort, nums1, nums2, m, n);
        int l = sort.length;
        return l%2==0 ? (float)(sort[l/2]+sort[l/2-1])/2 : sort[l/2];
    }

    public void MergeSortedArrays(int [] sort, int[] nums1, int[] nums2, int m, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, sort, 0, n);
            return;
        }
        if (n == 0) {
            System.arraycopy(nums1, 0, sort, 0, m);
            return;
        }

        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) sort[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        if (p1 >= 0) System.arraycopy(nums1, 0, sort, 0, p+1);
        if (p2 >= 0) System.arraycopy(nums2, 0, sort, 0, p+1);
    }
    */
    // O(m + n)
    // 2091/2091 cases passed (3 ms)
    // Your runtime beats 82.47 % of java submissions
    // Your memory usage beats 46.03 % of java submissions (39.8 MB)
}
// @lc code=end
