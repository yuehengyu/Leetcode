package com.yhy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        List<HashSet<Character>> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
            }
            list.add(set);
        }

        for (HashSet<Character> characters : list) {
            if (characters.size() > res)
                res = characters.size();
        }
        return res;
    }
}
