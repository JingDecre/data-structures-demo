package com.decre.data.mathematics.mathematicsdemo.binarytree;

/**
 * @className: FlipBinaryTree
 * @description: 翻转二叉树（LeetCode 226）
 * @author: decre
 * @date: 2021/3/24
 **/
public class FlipBinaryTree {
    // 二叉树节点
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 普通二叉树翻转
     *
     * @param root
     * @return
     */
    private static TreeNode flip(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            flip(root.left);
        }
        if (root.right != null) {
            flip(root.right);
        }
        return root;
    }
}
