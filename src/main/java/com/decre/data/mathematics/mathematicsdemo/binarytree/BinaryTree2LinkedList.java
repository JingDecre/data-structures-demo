package com.decre.data.mathematics.mathematicsdemo.binarytree;

/**
 * @className: BinaryTree2LinkedList
 * @description:  二叉树转单链表
 * @author: decre
 * @date: 2021-3-28 16:24
 **/
public class BinaryTree2LinkedList {

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2), new Node(3));
        transfer(root);
        System.out.println(root);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private static void transfer(Node root) {
        if (root == null) return ;
        transfer(root.left);
        transfer(root.right);
        // 后序遍历设置
        // 1、左右子树已经被拉平成一条链表
        Node left = root.left;
        Node right = root.right;
        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        Node p = root;
        // 3、将原先的右子树接到当前右子树的末端
        while (p.right != null) {
            p= p.right;
        }
        p.right = right;

    }

}
