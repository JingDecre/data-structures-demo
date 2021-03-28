package com.decre.data.mathematics.mathematicsdemo.binarytree;

/**
 * @className: PerfectBinaryTree
 * @description: 完美二叉树填充每个节点的下个指针（LeetCode 116题）
 * @author: decre
 * @date: 2021/3/25
 **/
public class PerfectBinaryTree {

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);
        Node connect = connect(node1);
        System.out.println(connect);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 入口
     *
     * @param root
     * @return
     */
    private static Node connect(Node root) {
        if (root == null) return root;
        contactTwoNode(root.left, root.right);
        return root;
    }

    /**
     * 连接左右节点
     *
     * @param left
     * @param right
     */
    private static void contactTwoNode(Node left, Node right) {
        if (left == null || right == null) return;
        left.next = right;
        contactTwoNode(left.left, left.right);
        contactTwoNode(right.left, right.right);
        // 跨越父节点拼接
        contactTwoNode(left.right, right.left);
    }

}
