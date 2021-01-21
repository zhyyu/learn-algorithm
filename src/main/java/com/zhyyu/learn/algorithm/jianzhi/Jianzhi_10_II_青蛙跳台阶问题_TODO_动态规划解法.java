package com.zhyyu.learn.algorithm.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyu.yzy
 * @date 2021/1/21
 */
public class Jianzhi_10_II_青蛙跳台阶问题_TODO_动态规划解法 {

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(7));
    }

    static class Solution {

        private Map<Integer, Integer> stepsWayNumCache = new HashMap<>();

        public int numWays(int n) {
            if (n == 0) {
                return 1;
            }

            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            int numWays = (getNumWaysFromCache(n - 1) + getNumWaysFromCache(n - 2)) % 1000000007;
            stepsWayNumCache.put(n, numWays);
            return numWays;
        }

        private int getNumWaysFromCache(int step) {
            Integer numWay = stepsWayNumCache.get(step);
            if (numWay != null) {
                return numWay;
            }

            return numWays(step);
        }
    }

}
