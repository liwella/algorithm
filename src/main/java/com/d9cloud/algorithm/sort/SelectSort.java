package com.d9cloud.algorithm.sort;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/2/28
 */
public class SelectSort {

    private static int[] ints = {3, 53, 61, 43, 145, 1, 66, 23};

    private static void sort(int[] params) {
        for (int i = 0; i < params.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < params.length; j++) {
                if (params[min] > params[j]) {
                    min = j;
                }
            }
            int tmp = params[i];
            params[i] = params[min];
            params[min] = tmp;
        }
    }

    public static void main(String[] args) {
        sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

}
