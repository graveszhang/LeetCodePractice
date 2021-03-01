class Solution {
    public int minPatches(int[] nums, int n) {
        int len = nums.length, idx = 0, minpatch = 0;
        long x = 1; // maintain to cover [1, x-1]
        // long because n = 2147483647 case
        while (x <= n) {
            if (idx < len && nums[idx] <= x){
                x += nums[idx];
                idx += 1;
            }
            else {
                x *= 2; // add x to the nums and times 2 since it covers [1, 2x-1]
                minpatch += 1;
            }
        }
        return minpatch;
    }
}
