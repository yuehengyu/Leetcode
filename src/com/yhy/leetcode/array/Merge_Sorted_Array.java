package com.yhy.leetcode.array;

import java.util.PriorityQueue;

public class Merge_Sorted_Array {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * Note:
     *  The number of elements initialized in nums1 and nums2 are m and n respectively.
     *  You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
     *
     *  Example:
     *      Input:
     *          nums1 = [1,2,3,0,0,0], m = 3  // this number shows number of non-zero value
     *          nums2 = [2,5,6],       n = 3
     *
     *          Output: [1,2,2,3,5,6]
     *
     *
     *  Constraints:
     *      -10^9 <= nums1[i], nums2[i] <= 10^9
     *      nums1.length == m + n
     *      nums2.length == n
     */


    public void priorityQueue_solution(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++)
            queue.add(nums1[i]);

        for (int num : nums2)
            queue.add(num);

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = queue.poll();
        }

    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.add(1);
//        queue.add(4);
//        queue.add(3);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
    }
}
