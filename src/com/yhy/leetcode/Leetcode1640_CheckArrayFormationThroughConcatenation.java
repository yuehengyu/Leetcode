package com.yhy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Leetcode1640_CheckArrayFormationThroughConcatenation.java
 * @author Henry Yue
 * @Description Leetcode1640
 * @createTime 2021/01/20
 */
public class Leetcode1640_CheckArrayFormationThroughConcatenation {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        List<int[]> list = new ArrayList<>();
        int currIndex = 0;
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[j][0] != arr[i]) {
                    continue;
                }
                list.add(pieces[j]);
            }
        }

        int index = 0;
        for (int[] arrs : list) {
            for (int i = 0; i < arrs.length; i++) {
                temp[index] = arrs[i];
                index++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp[i])
                return false;
        }
        return true;
    }
}
