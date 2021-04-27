package com.yhy.leetcode;

import java.util.Stack;

public class Leetcode1021_RemoveOuterParentheses {


    /**
     * stack solution
     * @param str 传入的字符串
     * @return String
     */
    public String stackSolution(String str) {
        if (str.length() < 4)
            return "";
        String res = "";
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                stack.pop();
                if (stack.size() > 0) {
                    res += str.charAt(i);
                }

            } else {
                stack.push(str.charAt(i));
                if (stack.size() > 1) {
                    res += str.charAt(i);
                }
            }
        }
        return res;
    }

    /**
     * so smart solution:, it is from leetcode submission
     * @param str
     * @return
     */
    public String forloopSolution(String str) {
        StringBuilder s = new StringBuilder();
        int open = 0;
        for (char c : str.toCharArray()) {
            if (c == '(' && open++ > 0) s.append(c);

            else if (c == ')' && open-- > 1) s.append(c);
        }

        return s.toString();
    }

}
