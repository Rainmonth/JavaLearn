package com.rainmonth.leetcode.sort;

import java.util.Arrays;

/**
 * 链表操作示例
 */
public class ListOpDemo {
    public static void main(String[] args) {
        int n = 10;
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }

        System.out.println("反转前：" + Arrays.toString(list));
        System.out.println("反转后：" + Arrays.toString(invertList(list, 2, 8)));
    }

    /**
     * @param list [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     */
    public static int[] invertList(int[] list, int left, int right) {
        if (list == null) {
            return null;
        }
        if (list.length <= 1) {
            return list;
        }

        if (left == right) {
            return list;
        }

        // left = 2, right = 8;
        int i = 0;
        while (i <= (right - left) / 2) {
            int temp = list[left - 1 + i];
            list[left - 1 + i] = list[right - 1 - i];
            list[right - 1 - i] = temp;
            i++;
        }
        // 交换

        return list;
    }
}
