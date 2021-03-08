package com.decre.data.mathematics.mathematicsdemo.backtrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: Permute
 * @description:  不重复的全排列
 * @author: decre
 * @date: 2021/3/8
 **/
public class NotRepeatPermute {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4, 5};
        List<LinkedList<Integer>> result = permute(nums);
        System.out.println("结果集总数：" + result.size());
        result.forEach(list -> {
            System.out.println(list.toString());
        });
    }

    /**
     * 全排列入口
     *
     * @param nums 可选择列表
     */
    private static List<LinkedList<Integer>> permute(int[] nums) {
        // 全排列结果集合
        List<LinkedList<Integer>> result = new ArrayList<>();
        // 路径缓存集合
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(result, nums, path);
        return result;
    }

    /**
     * 不重复全排列核心递归方法
     *
     * @param result 全排列结果集合
     * @param nums 可选择列表
     * @param path 缓存的可回溯路径
     */
    private static void backtrack(List<LinkedList<Integer>> result, int[] nums,  LinkedList<Integer> path) {
        // 当路径长度等于原始数组长度时，说明已到最后一个元素，排列成立，加入结果集
        if (nums.length == path.size()) {
            // 需要new一个新的path加到结果集,因为path从头到尾固定一个句柄
            result.add(new LinkedList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            // 加入临时路径
            path.add(num);
            // 递归
            backtrack(result, nums, path);
            // 移除最后一个元素
            path.removeLast();
        }

    }
}
