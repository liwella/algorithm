package com.d9cloud.algorithm.array;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/01/14
 */
public class List<T> {

    private int size = 0;

    private Object[] container;

    private List() {
        container = new Object[10];
    }

    public List(int capacity) {
        container = new Object[capacity];
    }

    public boolean add(T t) {
        if (size == container.length) {
            Object[] newContainer = new Object[container.length + container.length/2];
            System.arraycopy(container, 0, newContainer, 0, container.length);
            container = newContainer;
        }
        container[size] = t;
        size++;
        return true;
    }

    public T get(int index) {
        if (index > size) {
            throw new RuntimeException("超出范围");
        }
        return (T) container[index];
    }

}
