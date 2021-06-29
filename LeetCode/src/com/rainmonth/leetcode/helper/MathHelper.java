package com.rainmonth.leetcode.helper;

/**
 * @author RandyZhang
 * @date 2021/6/25 11:09 下午
 */
public class MathHelper {

    public static void main(String[] args) {
        System.out.println(gcd(12, 24));
    }

    /**
     * 求a、b的最小公倍数
     *
     * @return a、b的最小公倍数
     */
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * 求a、b的最大公约数
     *
     * @return a、b最大公约数
     */
    public static int gcd(int a, int b) {
        return b > 0 ? gcd(a, a % b) : a;
    }
}
