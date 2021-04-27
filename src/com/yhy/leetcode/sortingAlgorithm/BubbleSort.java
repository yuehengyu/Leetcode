package com.yhy.leetcode.sortingAlgorithm;

/**
 * @ClassName BubbleSort.java
 * @author Henry Yue
 * @Description 冒泡排序
 * @createTime 2021/01/12
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 2, 76, 12312, 231, 6534, 423, 8221, 7782, 123723, 123, 23, 234, 12, 34};
//        bubbleSort(nums);
//        bubbleSort1(nums);
//        bubbleSort2(nums);
        bubbleSort3(nums);
        System.out.println(nums);
    }

    /**
     * 暴力实现，遍历所有元素， 不考虑已经排序好的元素
     * @param nums 无序数组, nums.length >= 2
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //一定要注意这层循环的index不要写错， 我第一次就写成j=i了。。
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化尾部index， 已经排序好的元素不需要再比较第二次
     * @param nums 无序数组, nums.length >= 2
     */
    public static void bubbleSort1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //一定要注意这层循环的index不要写错， 我第一次就写成j=i了。。
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 加入flag，如果没有元素位置改变则终止循环
     * @param nums 无序数组, nums.length >= 2
     */
    public static void bubbleSort2(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            //一定要注意这层循环的index不要写错， 我第一次就写成j=i了。。
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }
    }


    /**
     * 加入lastExchange，通过此来减少排序的次数
     * @param nums 无序数组, nums.length >= 2
     */
    public static void bubbleSort3(int[] nums) {

        int lastExchange = 0, unSortedLength = nums.length - 1;

        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            //一定要注意这层循环的index不要写错， 我第一次就写成j=i了。。
            for (int j = 0; j < unSortedLength; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false;
                    //这里记录lastExchange的元素index
                    lastExchange = j;
                }
            }
            if (isSorted) {
                break;
            }
            //更新第二层循环的范围，只需要排序无序区即可
            unSortedLength = lastExchange;
        }
    }
}
