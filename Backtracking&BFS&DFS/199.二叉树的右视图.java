import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {    
        List<Integer> res = new ArrayList<>();
        addNode(root, 0, res);
        return res;
    }

    private void addNode(TreeNode root, int depth, List<Integer> res){
        if (root == null) return;

        if (depth == res.size()) res.add(root.val);

        addNode(root.right, depth+1, res);
        addNode(root.left, depth+1, res);
    }
}
// @lc code=end

