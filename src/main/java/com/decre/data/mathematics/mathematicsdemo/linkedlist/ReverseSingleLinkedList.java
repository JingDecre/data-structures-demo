package com.decre.data.mathematics.mathematicsdemo.linkedlist;

/**
 * @className: ReverseLinkedList
 * @description: 反转单链表（Leetcode 92）
 * @author: decre
 * @date: 2021/3/18
 **/
public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
       // ListNode reverse = reverseRange(listNode2, listNode4);
        ListNode reverse = reverseKGroup(listNode1, 2);
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
            // 最后一个节点跟后驱节点successor建立联系
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        // 建立死循环
        head.next.next = head;
        // 解开循环
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

    // 反转以 a 为头结点的链表（普通反转）
    private static ListNode reverse(ListNode a) {
        ListNode pre, cur, next;
        cur = a;
        pre = null; next = a;
        while (cur != null) {
            next = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = next;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * 反转a到b区间的链表
     *
     * @param a
     * @param b
     * @return
     */
    private static ListNode reverseRange(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * k个一组反转
     *
     * @param head
     * @param k
     * @return
     */
    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个， 不需要反转， base core
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverseRange(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
