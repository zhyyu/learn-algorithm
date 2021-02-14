package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_47_礼物的最大价值 {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().maxValue(grid));
    }

    static class Solution {
        public int maxValue(int[][] grid) {
            int rowNums = grid.length;
            int columnNums = grid[0].length;
            int[][] dp = new int[rowNums][columnNums];


            for (int i = 0; i < rowNums; i++) {
                int[] row = grid[i];
                for (int j = 0; j < row.length; j++) {
                    int val = row[j];
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + val;
                    }

                    if (i == 0 && j == 0) {
                        dp[i][j] = val;
                    }

                    if (i == 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1] + val;
                    }

                    if (i > 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j] + val;
                    }
                }
            }

            return dp[rowNums - 1][columnNums - 1];
        }
    }

}
