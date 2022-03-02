package com.d9cloud.algorithm.sort;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/3/1
 */
public class MergeSort {

    private static int[] params = {3, 53, 61, 43, 145, 1, 66, 23, 52, 92};

    private static void sort(int[] params, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        sort(params, start, middle);
        sort(params, middle + 1, end);
        merge(params, start, end);
    }

    private static void merge(int[] params, int start, int end) {
        int middle = (start + end) / 2;
        int i = start, j = middle + 1, k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= middle && j <= end) {
            if (params[i] <= params[j]) {
                temp[k++] = params[i++];
            } else {
                temp[k++] = params[j++];
            }
        }
        int remainStart = i, remainEnd = middle;
        if (j <= end) {
            remainStart = j;
            remainEnd = end;
        }
        for (int l = remainStart; l <= remainEnd; l++) {
            temp[k++] = params[l];
        }
        for (int m = 0; m < temp.length; m++) {
            params[start + m] = temp[m];
        }
    }

    public static void main(String[] args) {
        sort(params, 0, params.length - 1);
        for (int i = 0; i < params.length; i++) {
            System.out.print(params[i] + ",");
        }
    }

}
