package com.yhy.leetcode.array;

import java.util.LinkedList;

public class Duplicate_Zeros {

    /**
     * Given a fixed length array arr of integers, duplicate each occurrence of zero,
     * shifting the remaining elements to the right.
     *
     * Note that elements beyond the length of the original array are not written.
     * Do the above modifications to the input array in place, do not return anything from your function.
     *
     * Example 1:
     * Input: [1,0,2,3,0,4,5,0]
     * Output: null
     * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
     *
     * Example 2:
     * Input: [1,2,3]
     * Output: null
     * Explanation: After calling your function, the input array is modified to: [1,2,3]
     *
     * Note:
     *  1 <= arr.length <= 10000
     *  0 <= arr[i] <= 9
     */


    /**
     * force solution: if we meet 0, all elements from i+1 to end go back one index
     * and then set arr[i+1] = arr[i], we can also set 0 here.
     * PS: if arr[i]=0, since we set arr[i+1]=0 also, so index shoule be i+2 rather than i++;
     * @param arr
     */
    public void force_sloutions(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; ) {
            if (arr[i] == 0) {
                for (int j = length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = arr[i];
                i = i + 2;
            } else {
                i++;
            }
        }
    }

    /**
     * more efficient way, push all elements to a queue(need to push to last rather than first),
     * if meet 0 push it one more time, and then reset all value of arr[] using queue popup function
     * @param arr
     */
    public void queue_solitions(int[] arr) {
        LinkedList<Integer> queue = new LinkedList<>();

        for (int num : arr) {
            queue.addLast(num);
            if (num == 0) {
                queue.addLast(num);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.removeFirst();
        }
    }
}
