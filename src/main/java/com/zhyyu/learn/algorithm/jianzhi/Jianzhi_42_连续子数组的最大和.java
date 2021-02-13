package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Arrays;

public class Jianzhi_42_连续子数组的最大和 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            // 以nums arr index 为递推条件
            int[] dp = new int[nums.length];
            dp[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            }

            // 返回dp 数组最大值
            return Arrays.stream(dp).max().getAsInt();
        }
    }

}
