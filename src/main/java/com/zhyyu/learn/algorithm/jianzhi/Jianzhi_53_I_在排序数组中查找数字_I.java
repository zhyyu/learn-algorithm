package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_53_I_在排序数组中查找数字_I {

    public static void main(String[] args) {

    }

    static class Solution {
        public int search(int[] nums, int target) {
            int cnt = 0;

            boolean found = false;
            for (int num : nums) {
                if (num == target) {
                    cnt++;
                    found = true;
                    continue;
                }

                if (found && num == target) {
                    cnt++;
                }

                if (found && num != target) {
                    break;
                }
            }

            return cnt;
        }
    }

}
