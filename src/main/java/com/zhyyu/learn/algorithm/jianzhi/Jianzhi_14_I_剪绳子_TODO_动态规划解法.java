package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/22
 * @see https://github.com/CyC2018/CS-Notes/blob/master/notes/14.%20%E5%89%AA%E7%BB%B3%E5%AD%90.md
 */
public class Jianzhi_14_I_剪绳子_TODO_动态规划解法 {

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(20));
    }

    // 数学分析：3 数量最多，则乘积最大, 若%3 为1， 则将一对1，3 变为2，2
    static class Solution {
        public int cuttingRope(int n) {
            if (n == 2) {
                return 1;
            }

            if (n == 3) {
                return 2;
            }

            int threeNum = n / 3;
            int remainNum = n % 3;

            int twoNum = 0;
            if (remainNum == 2) {
                twoNum = 1;
            } else if(remainNum == 1) {
                threeNum--;
                twoNum += 2;
            }

            int result = 1;
            for (int i = 0; i < threeNum; i++) {
                result = result * 3;
            }

            for (int i = 0; i < twoNum; i++) {
                result = result * 2;
            }

            return result;
        }
    }

    // TODO: juror 2021/1/22 动态规划解法
    // d[i] = max(d[i], d[j] * (i - j))


/*    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[i - j], (i - j)) * j);
                }
            }

            return dp[n] % 1000000007;
        }
    }*/



}
