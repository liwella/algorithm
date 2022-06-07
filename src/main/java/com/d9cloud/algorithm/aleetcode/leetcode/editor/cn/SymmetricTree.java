//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1949 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import com.d9cloud.algorithm.aleetcode.leetcode.editor.cn.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {

//leetcode submit region begin(Prohibit modification and deletion)
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

    /*// 递归法，后续遍历
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compareRightLeft(root.left, root.right);
    }

    private boolean compareRightLeft(TreeNode left, TreeNode right) {
        if (right == null && left == null) {
            return true;
        } else if (right == null || left == null || right.val != left.val) {
            return false;
        }

        boolean compareOut = compareRightLeft(left.left, right.right);
        boolean compareIn = compareRightLeft(left.right, right.left);
        return compareIn && compareOut;
    }*/

    // 迭代法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root.left);
        queue.offerLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.pollFirst();
            TreeNode rightNode = queue.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            } else if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            queue.offerFirst(leftNode.left);
            queue.offerFirst(leftNode.right);
            queue.offerLast(rightNode.right);
            queue.offerLast(rightNode.left);
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
    }

}