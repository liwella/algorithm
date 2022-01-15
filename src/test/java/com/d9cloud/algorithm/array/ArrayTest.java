package com.d9cloud.algorithm.array;

import org.junit.Test;

/**
 * Description:
 *
 * @author: litianyi
 * @date: Created on 2022/01/14
 */
public class ArrayTest {

    @Test
    public void test1() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList);
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.size());
    }

}
