package com.zhyyu.learn.algorithm.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyu.yzy
 * @date 2021/1/21
 */
public class Jianzhi_10_I_斐波那契数列 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(43));
    }

    static class Solution {

        private Map<Integer, Integer> fibCache = new HashMap<>();

        public int fib(int n) {
            if (n == 0) {
                return 0;
            }

            if (n == 1) {
                return 1;
            }

            int result = (getFibFromCache(n - 1) + getFibFromCache(n - 2)) % 1000000007;
            fibCache.put(n, result);
            return result;
        }

        private int getFibFromCache(int n) {
            Integer cacheResult = fibCache.get(n);
            if (cacheResult != null) {
                return cacheResult;
            }

            return fib(n);
        }

    }

}
