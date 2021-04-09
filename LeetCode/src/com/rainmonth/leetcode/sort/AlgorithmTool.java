package com.rainmonth.leetcode.sort;

import java.util.Arrays;

public class AlgorithmTool {
    /**
     * 二分法查找
     *
     * @param arr 带查找数组
     * @param key 带查找元素
     * @return the Array index of value key
     */
    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1)
            return;
        // 普通方法
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;

        // 位运算
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[j] ^ arr[i];
//        arr[i] = arr[i] ^ arr[j];

        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    /**
     * 每次插入后，保证插入点以前的都是有序的。
     *
     * @param arr 待排序的Array
     */
    public static void insertSort(int[] arr) {
        int insertNode;// 要出入的数据
        int i, j;
        System.out.println("插入排序前：" + Arrays.toString(arr));
        for (i = 1; i < arr.length; i++) {
            // 从第二个元素开始循环将数据插入
            insertNode = arr[i];
            j = i - 1;
            // 找到要出入的位置
            while (j >= 0 && insertNode < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNode;
            System.out.println("第" + i + "轮插入后：" + Arrays.toString(arr));
        }
        System.out.println("插入排序后：" + Arrays.toString(arr));
    }

    /**
     * 每一轮冒泡都是找到最大的值（最大值会冒泡到最后）
     *
     * @param arr 待排序的Array
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("冒泡前：" + Arrays.toString(arr));
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
                    swap(arr, j, j + 1);
//                    System.out.println("内部第" + j + "冒泡：" + Arrays.toString(arr));
//                    System.out.println("交换后：" + Arrays.toString(arr));
                }
//                System.out.println("交换后：" + Arrays.toString(arr));
            }
            System.out.println("第" + (i + 1) + "轮冒泡找到最大值：" + arr[arr.length - 1 - i]);
            System.out.println("冒泡后：" + Arrays.toString(arr));
        }
    }

    /**
     * 每次选出的都是最小的值
     *
     * @param arr 待排序的Array
     */
    public static void selectSort(int[] arr) {
        System.out.println("选择排序前：" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {// 注意这里的边界是arr.length
            int temp = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    index = j;
                }
            }
            // 不是同一个位置就交换
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = temp;
            }
            System.out.println("第" + (i + 1) + "轮选择后" + Arrays.toString(arr));
        }
        System.out.println("选择排序后：" + Arrays.toString(arr));
    }

    public static void searchRepeatIndex(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("重复元素index=" + i);
                    break;
                }
            }
        }
    }

    public static void primeFactorization(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i);
                if (n != i) {
                    System.out.print("*");
                }
                primeFactorization(n / i);
                break;// 这里加上循环是为了防止进入迭代之后for循环仍然可以运行
            }
        }
//        System.exit(0); //退出程序

    }

    public static void getPrimeNumbers(int start, int end) {
        if (start > end || start < 0)
            return;
        System.out.println(start + "到" + end + "的素数为：");
        for (int i = start; i < end; i++) {
            boolean flag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(" " + i);
            }
        }
    }

    /**
     * 获取区间内的水仙花数（一个三位数，其值等于各个数位上的数字的立方和）
     *
     * @param start 开始区间
     * @param end   结束区间
     */
    public static void getSxhNumbers(int start, int end) {
        if (start < 100 || start > 999 || end < 100 || end > 999 || end < start)
            return;
        System.out.println(start + "到" + end + "的水仙花数为：");
        for (int i = start; i <= end; i++) {
            if (isSxhNumber(i)) {
                System.out.print(i + " 13");
            }
        }
    }

    private static boolean isSxhNumber(int x) {
        int i, j, k;
        i = x / 100;
        j = (x % 100) / 10;
        k = x % 10;

        return x == (i * i * i + j * j * j + k * k * k);
    }

    /**
     * 将数字字符串转换成数字
     *
     * @param intStr 数字字符串 "123"
     * @return 返回的数字
     */
    private static int strToInt(String intStr) {
        int number = 0;

        return number;
    }
}
