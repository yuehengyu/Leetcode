package com.yhy.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Java1027_testing {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(6);
        queue.offer(5);
        queue.offer(6);
        queue.offer(8);
        queue.offer(4);
        queue.offer(7);
        partition(queue, 6);
        System.out.println(queue.toString());
    }

    public static void partition(Queue<Integer> queue, int target) {
        Stack<Integer> temp = new Stack<>();

        int size = queue.size();
        int duplicate = 0;
        while (size > 0) {
            int curr = queue.poll();
            if (curr >= target) {
                if (curr == target) {
                    duplicate++;
                }
                temp.push(curr);
            } else {
                queue.offer(curr);
            }
            size--;
        }
        while (!temp.isEmpty()) {
            int curr = temp.pop();
            if (duplicate > 0) {
                if (curr == target) {
                    duplicate--;
                    queue.offer(curr);
                } else {
                    temp.push(curr);
                }
            }else{
                queue.offer(curr);
            }
        }

    }
}
