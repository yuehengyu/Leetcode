package com.yhy.leetcode;

import java.util.HashMap;

public class Leetcode136_SingleNumber {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int val : map.keySet()) {
            if (map.get(val) == 1)
                res = val;
        }
        return res;
    }
}
