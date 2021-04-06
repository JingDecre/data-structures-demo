package com.decre.data.mathematics.mathematicsdemo.binarytree;

import java.util.Arrays;

/**
 * @className: BuildTreeByPreAndMid
 * @description: 根据前序和中序遍历构造二叉树（105 题）
 * @author: decre
 * @date: 2021/4/3
 **/
public class BuildTreeByPreAndMid {


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Node root = buildTree(preorder, inorder);
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

    /**
     * 入口函数
     *
     * @param preorder
     * @param inorder
     * @return
     */
    private static Node buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 前序遍历的第一个就是当前节点
        Node root = new Node(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            // 中序遍历等于前序遍历第一个节点的下标，往左即为左子树，往右即为右子树
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }

        }
        return root;
    }
}
