package com.yhy.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * @ClassName BubbleSort.java
 * @author Henry Yue
 * @Description 选择排序
 * @createTime 2021/01/14
 */
public class SelectionSort {

    public static void main(String[] args) {
        //diff test cases
//        int[] nums = {3, 4, 1, 2, 76, 12312, 231, 6534, 423, 8221, 231, 7782, 123723, 123, 23, 234, 12, 34};
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
//        int[] nums = {3, 2, 2, 2, 21, 20};
//        int[] nums = {3, 2, 2, 2, 2, 2, 1};
//        selectionSort(nums);
        selectionSort1(nums);

        System.out.println(Arrays.toString(nums));
    }


    /**
     * 每次找到最小值，并记录index， 然后和当前无序区最左边的数进行交换
     * @param nums 无序数组, nums.length >= 2
     */
    public static void selectionSort(int[] nums) {

        int left = 0;
        //为什么是length-1: 因为如果只剩下一个数的时候就不需要比了，因为只剩一个数了
        while (left < nums.length - 1) {
            int minValIndex = left;
            for (int i = left; i < nums.length; i++) {
                if (nums[i] < nums[minValIndex]) {
                    minValIndex = i;
                }
            }
            int temp = nums[left];
            nums[left] = nums[minValIndex];
            nums[minValIndex] = temp;
            left++;
        }
    }


    /**
     * 每次同时找到最大和最小值，并交换位置到当前无序区的头部和末尾
     * @param nums 无序数组, nums.length >= 2
     */
    public static void selectionSort1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int minValIndex, maxValIndex;
        while (left < right) {
            minValIndex = left;
            maxValIndex = right;
            for (int i = left; i <= right; i++) {
                if (nums[i] > nums[maxValIndex]) {
                    maxValIndex = i;
                }
                if (nums[i] < nums[minValIndex]) {
                    minValIndex = i;
                }
            }

            //交换最小值的位置到最左边
            int temp = nums[left];
            nums[left] = nums[minValIndex];
            nums[minValIndex] = temp;
            if (left == maxValIndex) {
                maxValIndex = minValIndex;
            }
            //交换最大值的位置到末尾
            temp = nums[right];
            nums[right] = nums[maxValIndex];
            nums[maxValIndex] = temp;
            left++;
            right--;
        }
    }
}
