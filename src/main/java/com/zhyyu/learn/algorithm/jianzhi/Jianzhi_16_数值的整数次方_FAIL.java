package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_16_数值的整数次方_FAIL {

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0, -2));
    }

    static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }

            double result = 1.0;
            if (n > 0) {
                for (int i = 0; i < n ; i++) {
                    result = result * x;
                }
                return result;
            }

            double denominator = 1.0;
            if (n < 0) {
                for (int i = 0; i < -n ; i++) {
                    denominator = denominator * x;
                }
            }

            return 1.0 / denominator;
        }
    }

}
