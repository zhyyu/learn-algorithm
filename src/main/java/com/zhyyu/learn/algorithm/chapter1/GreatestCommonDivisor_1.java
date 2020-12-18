package com.zhyyu.learn.algorithm.chapter1;

/**
 * @author zhongyu.yzy
 * @date 2020/12/16
 */
public class GreatestCommonDivisor_1 {

    public static void main(String[] args) {
        System.out.println(calculateGreatestCommonDivisor(6, 4));
    }

    public static int calculateGreatestCommonDivisor(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend;
        }

        int remainder = dividend % divisor;
        return calculateGreatestCommonDivisor(divisor, remainder);
    }

}
