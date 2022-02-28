package com.d9cloud.algorithm.sort;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/2/28
 */
public class BubbleSort {

    private static int[] ints = {3, 53, 61, 43, 145, 1, 66, 23};

    private static void sort(int[] params) {
        for (int i = 0; i < params.length - 1; i++) {
            for (int j = 0; j < params.length - i - 1; j++) {
                if (params[j] > params[j + 1]) {
                    int temp = params[j + 1];
                    params[j + 1] = params[j];
                    params[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

}
