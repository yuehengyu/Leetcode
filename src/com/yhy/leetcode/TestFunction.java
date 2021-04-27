package com.yhy.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TestFunction {

    public static void main(String[] args) {
        int[] A = {3, 1, 7, 2};
        mergeSort(A, 0, 3);
        System.out.println(1/2);
    }

    public static void mergeSort(int[] A, int left, int right) {
        if (right > left) {
            int middle = (left + right) / 2;
            mergeSort(A, left, middle);
            mergeSort(A, middle + 1, right);
//            Merge(A, left, middle, right);
        }
    }
}
