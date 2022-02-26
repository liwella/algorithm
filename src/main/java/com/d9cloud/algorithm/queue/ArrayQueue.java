package com.d9cloud.algorithm.queue;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/2/26
 */
public class ArrayQueue {

    private String[] ts;
    private int capacity;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue() {
        this.capacity = 10;
        ts = new String[10];
    }

    public ArrayQueue(Integer capacity) {
        this.capacity = capacity;
        ts = new String[this.capacity];
    }

    public boolean enqueue(String t) {
        if (tail == capacity) {
            if (head == 0) return false;
            if (tail - head >= 0) System.arraycopy(ts, head, ts, 0, tail - head);
            tail -= head;
            head = 0;
        }
        ts[tail] = t;
        tail++;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String res = ts[head];
        head++;
        return res;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0; i < 15; i++) {
            System.out.println(queue.enqueue(i+""));
        }
        System.out.println("dequeue: " + queue.dequeue());
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
    }

}
