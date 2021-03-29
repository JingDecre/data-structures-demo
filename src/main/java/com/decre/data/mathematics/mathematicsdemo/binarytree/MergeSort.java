package com.decre.data.mathematics.mathematicsdemo.binarytree;

import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

import java.util.Arrays;

/**
 * @className: MergeSort
 * @description: 归并排序
 * @author: decre
 * @date: 2021/3/22
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.randomInit(10);
        System.out.println(Arrays.toString(nums));
        int[] tempArr = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tempArr);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int left, int right, int[] tempArr) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid, tempArr);
            mergeSort(nums, mid + 1, right, tempArr);
            merge(nums, left, mid, right, tempArr);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tempArr) {
        int l = left;
        int r = mid + 1;
        // 临时数组每次都从0下标开始
        int index = 0;
        // 当某一个不满足时，说明有一边已经排序完成了
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                tempArr[index] = nums[l];
                l++;
                index++;
            }
            if (nums[r] <= nums[l]) {
                tempArr[index] = nums[r];
                r++;
                index++;
            }
        }
        // 剩余左边的加入临时数组
        while (l <= mid) {
            tempArr[index] = nums[l];
            l++;
            index++;
        }
        // 剩余右边的加入临时数组
        while (r <= right) {
            tempArr[index] = nums[r];
            r++;
            index++;
        }
        // 将有序临时数组的数据替换原始数组left->right下标范围的数据
        index = 0;
        for (int i = left; i<= right; i++) {
            nums[i] = tempArr[index];
            index++;
        }
    }
}
