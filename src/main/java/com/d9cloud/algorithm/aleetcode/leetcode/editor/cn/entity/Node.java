package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn.entity;

import java.util.List;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/6/5
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
