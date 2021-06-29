package com.rainmonth.leetcode.array;

import java.util.Arrays;

/**
 * 翻转数组
 * 问题描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * @author RandyZhang
 * @date 2021/6/23 7:11 上午
 */
public class No189ArrayInverse {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};

        ArrayInverseSolution1 solution1 = new ArrayInverseSolution1();
        solution1.rotate(nums1, 2);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        ArrayInverseSolution3 solution3 = new ArrayInverseSolution3();
        solution3.rotate(nums3, 2);
        System.out.println(Arrays.toString(nums3));
    }
}

/**
 * 采用一个等长的数组，将旋转后的内容copy到这个数组
 */
class ArrayInverseSolution3 {
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        int[] temp = new int[length];
        int move = k % length;
        for (int i = 0; i < length; i++) {
            temp[(i + move) % length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, length);
    }

}


/**
 * 环状替换
 */
class ArrayInverseSolution2 {
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int temp;
        int length = nums.length;
        for (int i = 0;i<length;i++) {

        }
    }
}

/**
 * 采用递归的方法实现
 */
class ArrayInverseSolution1 {
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        k %= n;
        if (n < 2 || k == 0) {
            return;
        }
        rotate(nums, 0, n - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);
    }

    /**
     * 控件复杂度O(1)
     * 时间复杂度O(n)
     */
    private void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            ++start;
            --end;
        }
    }
}
