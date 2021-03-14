package com.decre.data.mathematics.mathematicsdemo.search;

/**
 * @className: BinarySearch
 * @description: 有序的二分查找法、
 *
 * @author: decre
 * @date: 2021-3-14 19:58
 **/
public class SortBinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int result = binarySearch(nums, 9);
        System.out.println(result);
    }

    /**
     *
     *
     * @param nums 查找的升序数据集合
     * @param target 目标值
     * @return 目标值命中的下标
     */
    private static int binarySearch(int[] nums, int target) {
        // 左边界下标
        int left = 0;
        // 右边界下标
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

}
