//给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树中节点数量在 [1, 104] 范围内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 346 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import com.d9cloud.algorithm.aleetcode.leetcode.editor.cn.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevelsInBinaryTree {

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            double levelResult = 0.0;
            int len = queue.size();
            // 注意，不能用 while(len-- > 0),因为会改变 len 的值，导致84行除法的结果不正确；
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.pollFirst();
                levelResult += node.val;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(levelResult / len);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
    }

}