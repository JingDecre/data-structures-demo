package com.decre.data.mathematics.mathematicsdemo.linkedlist;

/**
 * @className: Palindrome
 * @description: 回文链表
 * @author: decre
 * @date: 2021/3/21
 **/
public class PalindromeLinkedList {

    public static void main(String[] args) {
        String str = "1221";
        System.out.println(isPalindrome(str));

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(listNode));
    }


    static class ListNode {
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

    /**
     * 获取以left、right为核心的回文字符串
     *
     * @param str
     * @param left
     * @param right
     * @return
     */
    private static String getPalindrome(String str, int left, int right) {
        char[] chars = str.toCharArray();
        while (left >= 0 && right < str.length() && chars[left] == chars[right]) {
            left--;
            right++;
        }
        // 返回以left和right为中心的最长回文字符串
        return str.substring(left + 1, right - left - 1);
    }

    /**
     * 判断是否为回文字符串
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static ListNode leftNode;

    /**
     * 是否回文链表
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome(ListNode head) {
        leftNode = head;
        return traverse(head);
    }

    /**
     * 判断是否回文链表
     *
     * @param right
     * @return
     */
    private static boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && leftNode.val == right.val;
        leftNode = leftNode.next;
        return res;
    }
}
