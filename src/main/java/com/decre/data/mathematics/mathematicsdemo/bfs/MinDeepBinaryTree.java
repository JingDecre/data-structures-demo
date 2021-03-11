package com.decre.data.mathematics.mathematicsdemo.bfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @className: MinBinaryTree
 * @description: bfs算法求二叉树最小深度
 * @author: decre
 * @date: 2021/3/11
 **/
public class MinDeepBinaryTree {
    /**
     * 问题分析
     * 1、start节点：root 树根节点
     * 2、target节点： 子节点都是null 的叶子节点
     * 3、每个非叶子节点拥有两个子节点
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode l1 = new TreeNode();
        TreeNode l2 = new TreeNode();
        TreeNode l3 = new TreeNode();
        TreeNode l4 = new TreeNode();
        TreeNode r1 = new TreeNode();
        TreeNode r2 = new TreeNode();
        TreeNode r3 = new TreeNode();
        TreeNode r4 = new TreeNode();
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;
        r3.left = l4;
        r3.right = r4;
        int depth = minDepth(root);
        System.out.println(depth);

    }

    static class TreeNode {
        TreeNode left;

        TreeNode right;
    }

    private static int minDepth(TreeNode root) {
        if (root == null ) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点填充到队列
        queue.offer(root);
        // 初始化步数,根节点本身是一层
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i< size; i++) {
                // 取出顶部节点，并删除
                TreeNode node = queue.poll();
                if (null == node.left && null == node.right ) {
                    return step;
                }
                // 将左右子节点加入队列
                queue.offer(node.left);
                queue.offer(node.right);
            }
            step++;

        }
        return step;

    }
}
