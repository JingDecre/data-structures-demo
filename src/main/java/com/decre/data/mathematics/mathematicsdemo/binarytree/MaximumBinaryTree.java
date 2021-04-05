package com.decre.data.mathematics.mathematicsdemo.binarytree;

import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

import java.util.Arrays;

/**
 * @className: MaximumBinaryTree
 * @description: 最大二叉树(Leetcode 654)
 * @author: decre
 * @date: 2021/3/31
 **/
public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.randomInit(10);
        Arrays.stream(nums).forEach(System.out::println);
        Node node = constructMaximumBinary(nums);
        System.out.println(node);
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
     * @param nums
     * @return
     */
    private static Node constructMaximumBinary(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 核心逻辑
     *
     * @param nums
     * @param le
     * @param ri
     * @return
     */
    private static Node build(int[] nums, int le, int ri) {
        if (le > ri) {
            return null;
        }

        int maxVal = Integer.MIN_VALUE;
        int index = le;
        for (int i = le; i <= ri; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                index = i;
            }
        }

        Node root = new Node(maxVal);
        root.left = build(nums, le, index - 1);
        root.right = build(nums, index + 1, ri);
        return root;

    }
}
