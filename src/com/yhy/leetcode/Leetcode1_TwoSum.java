package com.yhy.leetcode;

import java.util.HashMap;

public class Leetcode1_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = target - nums[i];
            if (map.containsKey(curr)) {
                return new int[]{i, map.get(curr)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
