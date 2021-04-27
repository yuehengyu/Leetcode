package com.yhy.leetcode;

/**
 * @ClassName Leetcode234_PalindromeLinkedList.java
 * @author Henry Yue
 * @Description Leetcode234_PalindromeLinkedList
 * @createTime 2021/01/25
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Leetcode234_PalindromeLinkedList {

    public static void main(String[] args) {
        Leetcode234_PalindromeLinkedList lp = new Leetcode234_PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(lp.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {

        ListNode newNode = head;
        ListNode reverseNode = reverse(newNode);

        while (reverseNode.next != null) {
            if (head.val != reverseNode.val) {
                return false;
            }

            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}
