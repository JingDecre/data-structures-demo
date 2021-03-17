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
        int[] nums = {-1, 0,2,2,2,2,2,2,2, 3, 5, 9, 12};
        int result = binarySearch(nums, 2);
        int leftResult = leftLimitBinarySearch(nums, 2);
        int rightResult = rightLimitBinarySearch(nums, 2);
        System.out.println(result);
        System.out.println(leftResult);
        System.out.println(rightResult);
    }

    /**
     * 基本二分查找，找到即返回
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

    /**
     * 最左二分查找法
     * 不断向左收缩范围
     *
     * @param nums 供查找的数组
     * @param target 目标值
     * @return 目标值的最左下标
     */
    private static int leftLimitBinarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        // 初始最左下标
        int left = 0;
        // 初始最右下标
        int right = nums.length - 1;

        while (left <= right) {
            // 中间下标
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1; // 这里需要减一，否则会出现死循环
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return  (nums[left] == target) ? left : -1;
    }

    /**
     * 最右二分查找法
     * 不断向左收缩范围
     *
     * @param nums 供查找的数组
     * @param target 目标值
     * @return 目标值的最有下标
     */
    private static int rightLimitBinarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        // 初始最左下标
        int left = 0;
        // 初始最右下标
        int right = nums.length - 1;

        while (left <= right) {
            // 中间下标
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 这里需要减一，否则会出现死循环
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return  (nums[right] == target) ? right : -1;
    }

}
