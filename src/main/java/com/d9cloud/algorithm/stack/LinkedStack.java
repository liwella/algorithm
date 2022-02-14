package com.d9cloud.algorithm.stack;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/2/14
 */
public class LinkedStack {

    class DoubleLinkedNode {
        private int data;
        private DoubleLinkedNode prev;
        private DoubleLinkedNode next;
        public DoubleLinkedNode(int data) {
            this.data = data;
        }
    }

    private int size;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public LinkedStack() {
        this.size = 0;
        this.head = new DoubleLinkedNode(-1);
        this.tail = new DoubleLinkedNode(-1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void add(int data) {
        DoubleLinkedNode node = new DoubleLinkedNode(data);
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        size++;
    }

    public int poll() {
        if (size == 0) {
            return -1;
        }
        DoubleLinkedNode node = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev.next = null;
        tail.prev = tail.prev.prev;
        node.prev = null;
        size--;
        return node.data;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return tail.prev.data;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        DoubleLinkedNode cursor = stack.head;
        for (int i = 0; i < stack.size; i++) {
            System.out.print(cursor.next.data);
            cursor = cursor.next;
        }
    }

}