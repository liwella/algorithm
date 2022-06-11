//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 
// 👍 751 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import com.d9cloud.algorithm.aleetcode.leetcode.editor.cn.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

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

    /*// 递归法
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> path = new LinkedList<>();
        buildPath(root, path, result);
        return result;
    }

    private void buildPath(TreeNode node, LinkedList<Integer> path, List<String> result) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                builder.append(path.get(i)).append("->");
            }
            builder.append(path.get(path.size() - 1));
            result.add(builder.toString());
            return;
        }
        if (node.left != null) {
            buildPath(node.left, path, result);
            path.removeLast();
        }
        if (node.right != null) {
            buildPath(node.right, path, result);
            path.removeLast();
        }
    }*/

    // 迭代法
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push(root.val + "");
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            if (node.left == null && node.right == null) {
                result.add(path);
                continue;
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                pathStack.add(path + "->" + node.right.val);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                pathStack.add(path + "->" + node.left.val);
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
    }

}