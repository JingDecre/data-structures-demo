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
            if (r <= l) {
                break;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            if (nums[l] == middleVal) {
                r--;
            }
            if (nums[r] == middleVal) {
                l++;
            }
        }
        // 防止死循环
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
