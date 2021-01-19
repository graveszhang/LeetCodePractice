// 简单思路 先找pivot 然后比较 => 复杂度O(n)
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：37.9 MB, 在所有 Java 提交中击败了51.73%的用户

class Solution {
    public int search(int[] nums, int target) {
        int idx_rotate = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[idx_rotate]){
                idx_rotate++;
            } else {
                break;
            }
        }
        if (target == nums[idx_rotate]){
            return idx_rotate;
        } else if (target < nums[idx_rotate] && target >= nums[0]){
            for (int j = 0; j <= idx_rotate; j++){
                if (target == nums[j]){
                    return j;
                }
            }
        } else if (target < nums[idx_rotate] && target <= nums[nums.length-1] && (idx_rotate + 1) < nums.length){
            for (int j = idx_rotate + 1; j <= nums.length-1; j++){
                if (target == nums[j]){
                    return j;
                }
            }
        } 
        return -1;
    }
}
