package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn.entity;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/03/31
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
