package com.decre.data.mathematics.mathematicsdemo.binarytree;

import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

import java.util.Arrays;

/**
 * @className: QuickSort
 * @description: 快速排序
 * @author: decre
 * @date: 2021/3/22
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.randomInit(10);
        System.out.println(Arrays.toString(nums));
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }


    /**
     * 算法核心逻辑
     *
     * @param nums  原始数组
     * @param left  左边界
     * @param right 有边界
     */
    private static void sort(int[] nums, int left, int right) {
        // 1、递归循环退出条件
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int middleIndex = left + (right - left) / 2;
        int middleVal = nums[middleIndex];

        while (l < r) {
            while (nums[l] < middleVal) {
                l++;
            }
            while (nums[r] > middleVal) {
                r--;
            }
            // 这里要大于等于
            if (l >= r) {
                break;
            }
            // 相对于middleIndex左边
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            // l与中间值相等，是r--  ! !
            if (nums[l] == middleVal) {
                r--;
            }
            // r与中间值相等，是l++  ! !
            if (nums[r] == middleVal) {
                l++;
            }
        }
        // 防止死循环，递归循环退出条件在方法入口处
        if (l == r) {
            l++;
            r--;
        }

        if (l < right) {
            sort(nums, l, right);
        }
        if (left < r) {
            sort(nums, left, r);
        }

    }
}
