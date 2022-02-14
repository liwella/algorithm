package com.d9cloud.algorithm.stack;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/02/14
 */
public class ArrayStack {

    private Integer[] array;
    private int size;
    private int capacity;

    public ArrayStack() {
        this.size = 0;
        this.capacity = 10;
        this.array = new Integer[capacity];
    }

    public void add(Integer number) {
        if (size == capacity) {
            this.capacity = capacity + capacity/2;
            Integer[] temp = new Integer[this.capacity];
            System.arraycopy(this.array, 0, temp, 0, size);
            this.array = temp;
        }
        this.array[size] = number;
        size++;
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer number = this.array[size - 1];
        this.array[size - 1] = null;
        size--;
        return number;
    }

    public Integer peek() {
        return this.array[size - 1];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 60; i++) {
            stack.add(i);
        }
        System.out.println(stack.peek());
        stack.poll();
        for (int i = 0; i < stack.size; i++) {
            System.out.print(stack.array[i] + ", ");
        }
    }

}
