package com.zhyyu.learn.algorithm.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_16_数值的整数次方 {

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0, 10));
        System.out.println(new Solution().myPow(2.1, 3));
        System.out.println(new Solution().myPow(2.0, -2));
    }

    static class Solution {

        private Map<Integer, Double> powCache = new HashMap<>();

        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }

            if (n == -1) {
                powCache.put(-1, 1.0 / x);
                return 1.0 / x;
            }

            if (n == -2) {
                powCache.put(-2, 1.0 / (x * x));
                return 1.0 / (x * x);
            }


            if (n == 1) {
                powCache.put(1, x);
                return x;
            }

            if (n == 2) {
                powCache.put(2, x * x);
                return x * x;
            }

            if (n % 2 == 0) {
                int first = n / 2;
                int second = n /2;
                Double result = powCache.get(n);
                if (result != null) {
                    return result;
                }
                result = myPow(x, first) * myPow(x, second);
                powCache.put(n, result);
                return result;
            } else if (n % 2 == 1) {
                int first = n / 2;
                int second = n / 2 + 1;
                Double result = powCache.get(n);
                if (result != null) {
                    return result;
                }
                result = myPow(x, first) * myPow(x, second);
                powCache.put(n, result);
                return result;
            } else if (n % 2 == -1) {
                int first = n / 2;
                int second = n / 2 - 1;
                Double result = powCache.get(n);
                if (result != null) {
                    return result;
                }
                result = myPow(x, first) * myPow(x, second);
                powCache.put(n, result);
                return result;
            }

            throw new RuntimeException("cannot reach");
        }



    }

}
