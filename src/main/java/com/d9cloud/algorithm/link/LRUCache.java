package com.d9cloud.algorithm.link;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/1/24
 */
public class LRUCache<T> {

    private LinkedList<T> list = new LinkedList<>();

    private int capacity = 10;

    public LRUCache() {
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public boolean get(T t) {
        T temp = null;
        for (T item : list) {
            if (item == t) {
                temp = item;
            }
        }
        if (temp != null) {
            list.remove(temp);
            list.addFirst(t);
        } else {
            if (list.size() < capacity) {
                list.addFirst(t);
            } else {
                list.removeLast();
                list.addFirst(t);
            }
        }
        return true;
    }

    public void print() {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer> lru = new LRUCache<>();
        for (int i = 0; i < 10; i++) {
            lru.get(i);
        }
        lru.get(15);
        lru.get(4);
        lru.print();
    }

}
