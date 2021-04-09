package com.rainmonth.leetcode.sort;

/**
 * 排序算法管理器
 *
 * @author RandyZhang
 */
public class SortManager {
    /**
     * 都按正序遍历（即从小到大的顺序）
     *
     * @param arr 待排序的arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    AlgorithmTool.swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 外层逆序，内存正序
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        boolean isLoop = true;
        for (int i = arr.length; isLoop && i > 0; --i) {
            isLoop = false;
            for (int j = 1; j < i; j++) {
                if (arr[j - 1] > arr[j]) {
                    AlgorithmTool.swap(arr, j - 1, j);
                    isLoop = true;
                }
            }
        }
    }

    /**
     * 获取一个长度为arrayLength的随机数数组，每个数字都不能重复，且每个数字都在start和end之间
     *
     * @param arrayLength 数组长度
     * @param start       数组中元素最小值
     * @param end         数组中元素最大值
     * @return
     */
    public int[] getRandomArray(int arrayLength, int start, int end) {
//        if(end < start)
        return new int[]{};
    }
}
