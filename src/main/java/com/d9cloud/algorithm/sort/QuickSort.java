package com.d9cloud.algorithm.sort;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/3/2
 */
public class QuickSort {

    private static int[] params = {3, 53, 61, 43, 145, 1, 66, 23, 52, 92};

    private static void sort(int[] params, int start, int end) {
        if (start >= end) return;
        int middle = partition(params, start, end);
        sort(params, start, middle -1);
        sort(params, middle + 1, end);
    }

    private static int partition(int[] params, int start, int end) {
        int pivort = params[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (params[j] <= pivort) {
                int temp = params[i];
                params[i] = params[j];
                params[j] = temp;
                i++;
            }
        }
        int temp = params[i];
        params[i] = pivort;
        params[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        sort(params, 0, params.length - 1);
        for (int i = 0; i < params.length; i++) {
            System.out.print(params[i] + ",");
        }
    }

}
