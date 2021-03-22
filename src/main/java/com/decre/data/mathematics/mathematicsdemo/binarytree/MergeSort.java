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

        int t = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                tempArr[t] = nums[l];
                l++;
                t++;
            } else {
                tempArr[t] = nums[r];
                r++;
                t++;
            }
        }
        while (l <= mid) {
            tempArr[t] = nums[l];
            l++;
            t++;
        }

        while (r <= right) {
            tempArr[t] = nums[r];
            r++;
            t++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            nums[tempLeft] = tempArr[t];
            tempLeft++;
            t++;
        }

    }
}
