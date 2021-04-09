package com.rainmonth.leetcode.sort;

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        int a = 2, b = 8;
        System.out.println(a ^ b);
        System.out.println("冒泡排序：");
        int arr[] = {6, 4, 8, 3, 2};
        SortManager.bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
        int arr1[] = {6, 4, 8, 3, 2};
        SortManager.bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
//        System.out.println("插入排序：");
//        int arr1[] = {6, 4, 8, 3, 2};
//        AlgorithmTool.insertSort(arr1);
//        System.out.println("选择排序：");
//        int arr2[] = {6, 4, 8, 3, 2};
//        AlgorithmTool.selectSort(arr2);
//
//        System.out.println("对应索引为：" + AlgorithmTool.binarySearch(arr1, 10));
//
//        AlgorithmTool.getPrimeNumbers(101, 200);
//        System.out.println();
//        AlgorithmTool.getPrimeNumbers(2, 100);
//        System.out.println();
//        System.out.println("请输入要分解的整数：");
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.print( "分解质因数：" + n +"=");
//        AlgorithmTool.primeFactorization(n);
//
//        System.out.println();
//        AlgorithmTool.getSxhNumbers(100,999);
    }
}
