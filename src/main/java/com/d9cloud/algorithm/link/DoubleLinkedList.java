package com.d9cloud.algorithm.link;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/01/24
 */
public class DoubleLinkedList {

    private Integer size = 0;

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
            size++;
            return true;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
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
        DoubleNode cur = head;
        while (cur != null && cur.data != data) {
            cur = cur.next;
        }
        if (cur != null) {
            if (cur.prev == null && size == 1) {
                head = cur.next;
            } else if (cur.prev == null && size > 1) {
                DoubleNode prev = head;
                head = cur.next;
                prev.next = null;
                head.prev = null;
            } else if (cur.next != null) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur.prev = null;
                cur.next = null;
            } else {
                tail = tail.prev;
                cur.prev.next = cur.next;
                cur.prev = null;
            }
            size--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(11);
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("before remove: " + list.get(i));
        }
        list.remove(4);
        for (int i = 0; i < 5; i++) {
            System.out.println("after remove: " + list.get(i));
        }
    }

}
