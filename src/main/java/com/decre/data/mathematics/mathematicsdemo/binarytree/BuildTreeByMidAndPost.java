package com.decre.data.mathematics.mathematicsdemo.binarytree;

import java.util.Arrays;

/**
 * @className: BuildTreeByMidAndPost
 * @description: 根据中序和后序遍历构建二叉树（LeetCode 106题）
 * @author: decre
 * @date: 2021-4-6 22:47
 **/
public class BuildTreeByMidAndPost {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 构建二叉树核心逻辑
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // 但数组为空返回null节点
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        // 后序遍历的倒数第一个节点即为当前节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
            }
        }
        return root;
    }


}
