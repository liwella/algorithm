package com.d9cloud.algorithm.link;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/01/24
 */
public class DoubleLinkedList {

    private Integer size;

    private DoubleNode head;

    private DoubleNode tail;

    private class DoubleNode {
        private DoubleNode next;
        private DoubleNode prev;
        private int data;
    }

    public boolean add(int data) {
        DoubleNode node = new DoubleNode();
        node.data = data;
        if (head == null) {
            head = node;
            tail = node;
            return true;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
        return true;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new RuntimeException("超出边界");
        }
        if (size / 2 > index) {
            int start = 0;
            DoubleNode cur = head;
            while (start != index) {
                cur = cur.next;
                start++;
            }
            return cur.data;
        } else {
            int end = size - 1;
            DoubleNode cur = tail;
            while (end != index) {
                cur = cur.prev;
                end--;
            }
            return cur.data;
        }
    }

    public boolean remove(int data) {
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = tail = null;
            return true;
        }
        DoubleNode prev = null;
        DoubleNode cur = head;
        while (cur != null && cur.data != data) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return false;
        }
        prev.next = cur.next;
        cur.next.prev = prev;
        return true;
    }

}
