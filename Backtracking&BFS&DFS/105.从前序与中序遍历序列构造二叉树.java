import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) hash.put(inorder[i], i);
        return dfs(preorder, 0, preorder.length-1, 0, inorder.length-1, hash);
    }

    public TreeNode dfs(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> hash){
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int root_idx = hash.get(root.val); 
        int left_size = root_idx - inStart;
    
        root.left = dfs(preorder, preStart + 1, preStart + left_size, inStart, root_idx - 1, hash);
        root.right = dfs(preorder, preStart + left_size + 1, preEnd, root_idx + 1, inEnd, hash);
        return root;
    }
}
// @lc code=end

