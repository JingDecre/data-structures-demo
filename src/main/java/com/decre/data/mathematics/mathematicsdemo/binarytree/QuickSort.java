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
     * @param nums 原始数组
     * @param left 左边界
     * @param right 有边界
     */
    private static void sort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        // 中间值下标
        int middleIndex = left + (right - left) / 2;
        // 中间值
        int middleVal = nums[middleIndex];
        int temp;
        while (l < r) {
            // 下标l仍然小于中间值说明不用交换
            while (nums[l] < middleVal) {
                l++;
            }
            while (nums[r] > middleVal) {
                r--;
            }
            // l >= r 说明左右已经全部比较过了，故跳出循环
            if (l >= r) {
                break;
            }

            // 左右需要交换
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            if (nums[l] == middleVal) {
                r--;
            }
            if (nums[r] == middleVal) {
                l++;
            }
        }
        // 避免死循环
        if (l == r) {
            l++;
            r--;
        }
        if (r > left) {
            sort(nums, left, r);
        }
        if (l < right) {
            sort(nums, l, right);
        }
    }
}
