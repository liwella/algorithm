package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn.entity.conflict;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/6/19
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}
