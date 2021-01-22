package com.zhyyu.learn.algorithm.jianzhi;

import java.math.BigInteger;

/**
 * @author zhongyu.yzy
 * @date 2021/1/22
 */
public class Jianzhi_14_II_剪绳子II {

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }

    // % 1000000007
    static class Solution {
        public int cuttingRope(int n) {
            BigInteger[] dp = new BigInteger[n + 1];
            for (int i = 2; i < dp.length; i++) {
                dp[i] = BigInteger.ZERO;
            }
            dp[1] = BigInteger.ONE;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = dp[i].max(dp[i - j].max(BigInteger.valueOf(i - j)).multiply(BigInteger.valueOf(j)));
                }
            }

            return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }

}
