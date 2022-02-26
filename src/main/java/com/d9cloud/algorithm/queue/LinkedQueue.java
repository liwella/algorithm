package com.d9cloud.algorithm.queue;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/2/26
 */
public class LinkedQueue {

    private class Node {
        public Node(String data) {
            this.data = data;
        }
        private String data;
        private Node next;
    }

    private Node head;
    private Node tail;

    public LinkedQueue() {
        head = tail = null;
    }

    public boolean enqueue(String data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }

    public String dequeue() {
        String res = null;
        if (head == null) {
            return res;
        }
        if (head == tail) {
            res = head.data;
            head = tail = null;
            return res;
        }
        res = head.data;
        Node tmp = head;
        head = head.next;
        tmp.next = null;
        return res;
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 15; i++) {
            System.out.println(linkedQueue.enqueue(i + ""));
        }
        System.out.println("linkedQueue dequeue: " + linkedQueue.dequeue());
        for (int i = 0; i < 15; i++) {
            System.out.println(linkedQueue.dequeue());
        }
    }

}
