package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_63_股票的最大利润 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int[] dp = new int[prices.length + 1];
            dp[1] = 0;
            int min = prices[0];

            for (int i = 2; i <= prices.length; i++) {
                dp[i] = Math.max(dp[i - 1], prices[i - 1] - min);
                if (dp[i] < 0) {
                    dp[i] = 0;
                }

                min = Math.min(min, prices[i - 1]);
            }

            return dp[prices.length];
        }
    }

}
