package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class Jianzhi_60_n个骰子的点数 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] doubles = solution.dicesProbability(2);
        for (int i = 0; i < doubles.length; i++) {
            double aDouble = doubles[i];
            System.out.println(aDouble);
        }
    }

    static class Solution {
        public double[] dicesProbability(int n) {
            int[][] dp = new int[n + 1][n * 6 + 1];
            dp[1][1] = 1;
            dp[1][2] = 1;
            dp[1][3] = 1;
            dp[1][4] = 1;
            dp[1][5] = 1;
            dp[1][6] = 1;

            int possibleCombine = 1;
            for (int i = 1 ; i <= n; i++) {
                possibleCombine = possibleCombine * 6;
            }

            if (n > 1) {
                for (int i = 2; i <= n; i++) {
                    for (int j = i; j <= 6 * i; j++) {
                        for (int dice = 1; dice <= 6; dice++) {
                            if (j - dice >= (i - 1) && j - dice <= (i - 1) * 6) {
                                dp[i][j] += dp[i - 1][j - dice];
                            }
                        }
                    }
                }
            }

            List<Double> possibleList = new ArrayList<>();
            for (int j = n; j <= 6 * n; j++) {
                possibleList.add(dp[n][j] * 1.0 / possibleCombine);
            }

            return possibleList.stream().mapToDouble(Double::doubleValue).toArray();
        }
    }

}
