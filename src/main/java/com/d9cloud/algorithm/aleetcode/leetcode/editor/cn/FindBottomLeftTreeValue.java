//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,104] 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 284 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import com.d9cloud.algorithm.aleetcode.leetcode.editor.cn.entity.TreeNode;

public class FindBottomLeftTreeValue {

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

    int maxLeftValue;
    int maxDeep = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 0);
        return maxLeftValue;
    }

    public void traverse(TreeNode node, int deep) {
        if (deep > maxDeep) {
            maxDeep = deep;
            maxLeftValue = node.val;
        }
        if (node.left != null) {
            deep++;
            traverse(node.left, deep);
            deep--;
        }
        if (node.right != null) {
            deep++;
            traverse(node.right, deep);
            deep--;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
    }

}