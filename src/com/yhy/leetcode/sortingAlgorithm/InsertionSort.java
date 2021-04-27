package com.yhy.leetcode.sortingAlgorithm;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        //diff test cases
        int[] nums = {3, 4, 1, 2, 76, 12312, 231, 6534, 423, 8221, 231, 7782, 123723, 123, 23, 234, 12, 34};
//        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
//        int[] nums = {3, 2, 2, 2, 21, 20};
//        int[] nums = {3, 2, 2, 2, 2, 2, 1};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 按照算法描述直接进行代码实现，采用in-place（不使用额外的数据结构）
     * @param nums 无序数组, nums.length >= 2
     */
    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //第一个数是默认有序的，所以我们从i的下一个数开始进行排序
            int currUnsortedIndex = i + 1;
            //已经找到需要排序的数字，然后遍历前面的有序区域，将这个数字插入到对应的位置，数组中进行插入其实就像交换元素位置
            for (int j = i; j >= 0; j--) {
                if (nums[j] > nums[currUnsortedIndex]) {
                    int temp = nums[currUnsortedIndex];
                    nums[currUnsortedIndex] = nums[j];
                    nums[j] = temp;
                    currUnsortedIndex = j;
                } else {
                    //如果前面有序区域的最大值已经小于当前未排序数字，则可以终止当前循环，开始下一次新的排序
                    break;
                }
            }
        }
    }
}
