package com.d9cloud.algorithm.link;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/01/15
 */
public class LinkedList {

    private int size;

    private Node head;

    private Node tail;

    private class Node {
        private int data;
        private Node next;
    }

    public boolean add(int data) {
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
            tail = head;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }

    public boolean remove(int data) {
        if (head == null) {
            return false;
        }
        Node prev = null;
        Node cur = head;
        while (cur.next != null && cur.data != data) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == head) {
            head = cur.next;
            cur.next = null;
        }
        if (cur.data != data) {
            return false;
        }

    }

}
