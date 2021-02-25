package com.decre.data.structures.datastructuresdemo.service.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liaofuan
 * @Description: 二分查找法
 * @Date: Created at 下午 04:04:23 2021年2月25日 0025
 * @Modified by:
 */
public class BinarySearch {


    /**
     * 获取找到的第一个下标
     *
     * @return
     */
    public int singleSearch(int[] arr, int left, int right, int finalVal) {
        // 当左下标大于右下标，说明该遍历方向没有命中
        if (left > right) {
            return -1;
        }
        // 获取中间下标
        int mid = (left + right) / 2;
        // 中间值
        int midVal = arr[mid];
        if (midVal > finalVal) {
            return singleSearch(arr, left, mid - 1, finalVal);
        } else if (midVal < finalVal) {
            return singleSearch(arr, mid + 1, right, finalVal);
        } else {
            return mid;
        }

    }

    /**
     * 获取找到的下标列表
     *
     * @return
     */
    public List<Integer> listSearch(int[] arr, int left, int right, int finalVal) {
        // 当左下标大于右下标，说明该遍历方向没有命中
        if (left > right) {
            return new ArrayList<>();
        }
        // 获取中间下标
        int mid = (left + right) / 2;
        // 中间值
        int midVal = arr[mid];
        if (midVal > finalVal) {
            return listSearch(arr, left, mid - 1, finalVal);
        } else if (midVal < finalVal) {
            return listSearch(arr, mid + 1, right, finalVal);
        } else {
            // 下标集合结果
            List<Integer> result = new ArrayList<>();
            // 添加找到的第一个下标
            result.add(mid);
            // 向左查找相等的下标
            int tempIndex = mid - 1;
            while (tempIndex >= 0 && arr[tempIndex] == midVal) {
                result.add(tempIndex);
                tempIndex--;
            }
            // 向右查找相等结果的下标
            tempIndex = mid + 1;
            while (tempIndex <= (arr.length - 1) && arr[tempIndex] == midVal ) {
                result.add(tempIndex);
                tempIndex++;
            }

            return result;
        }

    }
}
