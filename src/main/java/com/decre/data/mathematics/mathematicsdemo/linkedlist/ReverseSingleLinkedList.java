package com.decre.data.mathematics.mathematicsdemo.linkedlist;

/**
 * @className: ReverseLinkedList
 * @description: 反转单链表（Leetcode 92）
 * @author: decre
 * @date: 2021/3/18
 **/
public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode resultNode = null;
        ListNode reverse = reverseN(head, 3);
        System.out.println(reverse);
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
    private static ListNode successor = null;

    /**
     * 部分反转
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        // 头节点向前平移，left、right同时向后平移left - 1个单位，使left = 1
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    /**
     * // 反转以 head 为起点的 n 个节点，返回新的头结点
     *
     * @param head 头节点
     * @param n 前n个
     * @return
     */
    private static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 反转的结果
        ListNode last = reverseN(head.next, n - 1);
        // .next.next 先形成死循环
        head.next.next = head;
        // .next 解开死循环
        head.next = successor;
        return last;

    }

    /**
     * 完全链表反转
     *
     * @param head
     * @return
     */
    private static ListNode reverserAll(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverserAll(head.next);
        // head.next 即last节点
        head.next.next = head;
        // 断开如：4->5->4->5的死循环，所有值为4的下一个节点都为空
        // 最终保留，5->4->null，实现反转
        head.next = null;
        return last;
    }
}
