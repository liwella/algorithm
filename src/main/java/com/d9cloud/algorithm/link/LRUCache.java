package com.d9cloud.algorithm.link;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/1/24
 */
public class LRUCache {

    class DoubleLinkedNode {
        public int key;
        public int value;
        public DoubleLinkedNode prev;
        public DoubleLinkedNode next;
        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DoubleLinkedNode(-1,-1);
        this.tail = new DoubleLinkedNode(-1,-1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) return -1;
        removeNode(node);
        addNodeAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node != null) {
            removeNode(node);
            node.value = value;
            addNodeAtHead(node);
            return;
        }
        if (size == capacity) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
        cache.put(key, newNode);
        addNodeAtHead(newNode);
        size++;
    }

    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void addNodeAtHead(DoubleLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

}
