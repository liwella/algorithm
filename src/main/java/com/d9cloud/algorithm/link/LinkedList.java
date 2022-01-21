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
        size++;
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
        while (cur != null && cur.data != data) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return false;
        }
        if (prev == null) {
            prev = head;
            head = head.next;
            prev.next = null;
        } else {
            prev.next = prev.next.next;
        }
        size--;
        return true;
    }

    public Integer get(int index) {
        if (size == 0 || index >= size) {
            throw new RuntimeException("超出范围！");
        }
        int curIndex = 0;
        Node cur = head;
        while (cur != null) {
            if (curIndex == index) {
                break;
            }
            curIndex++;
            cur = cur.next;
        }
        if (cur == null) {
            return null;
        } else {
            return cur.data;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        System.out.println("size = " + linkedList.size);
        System.out.println("index 2: " + linkedList.get(2));
        linkedList.remove(4);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println("index i: " + linkedList.get(i));
        }
    }

}