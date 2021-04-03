package com.decre.data.mathematics.mathematicsdemo.binarytree;

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
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 核心计算逻辑
     *
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    private static Node build(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd) {
        // 递归终止条件
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的第一个节点是根节点
        int rootVal = preorder[preStart];
        // 中序遍历等于前序遍历根节点的下标
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        // 当前节点
        Node root = new Node(rootVal);
        // 左子树节点大小,中序遍历的左子树节点大小，同时也是前序遍历的左子树大小
        int leftSize = index - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;

    }
}
