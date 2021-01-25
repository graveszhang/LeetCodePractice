import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        bfs(ans, root);
        return ans;
    }

    public void bfs(List<List<Integer>> ans, TreeNode root){
        int curr = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.isEmpty() == false){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode n = queue.poll();
                tmp.add(n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            curr++;
            if (curr % 2 == 1) Collections.reverse(tmp);
            ans.add(tmp);
        }
    }
}

// @lc code=end

