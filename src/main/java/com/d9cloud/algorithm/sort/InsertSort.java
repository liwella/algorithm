package com.d9cloud.algorithm.sort;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/2/28
 */
public class InsertSort {

    private static int[] ints = {3, 53, 61, 43, 145, 1, 66, 23};

    private static void sort(int[] params) {
        if (params.length < 1) return;
        for (int i = 1; i < params.length; i++) {
            int value = params[i];
            int j = i - 1;
            while (j >= 0) {
                if (value < params[j]) {
                    params[j + 1] = params[j];
                } else {
                    break;
                }
                --j;
            }
            params[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

}
