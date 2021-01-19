import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.internal.icu.util.CodePointTrie.Fast;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(res, tmp, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int [] nums){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++){
                int cand = nums[i];
                if(tmp.contains(cand)) {
                    continue;
                } else {
                    tmp.add(cand);
                    backtrack(res, tmp, nums);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
// @lc code=end

