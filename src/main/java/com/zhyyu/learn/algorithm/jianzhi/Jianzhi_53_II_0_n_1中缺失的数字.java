package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_53_II_0_n_1中缺失的数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0, 1, 3}));
        System.out.println(new Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
        System.out.println(new Solution().missingNumber(new int[]{0, 1, 2, 4, 5, 6, 7}));
    }

    static class Solution {
        public int missingNumber(int[] nums) {
            if (nums.length == 1) {
                if (nums[0] == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }

            if (nums[nums.length - 1] == nums.length - 1) {
                return nums[nums.length - 1] + 1;
            }

            if (nums[0] != 0) {
                return 0;
            }

            // 二分查找
            int fromIndex = 0;
            int endIndex = nums.length - 1;

            while (true) {
                int midIndex = (fromIndex + endIndex) / 2;
                if (nums[midIndex] > midIndex) {
                    endIndex = midIndex;
                }

                if (nums[midIndex] == midIndex) {
                    fromIndex = midIndex;
                }

                if ((endIndex - fromIndex) == 1) {
                    return (nums[fromIndex] + nums[endIndex]) / 2;
                }
            }

        }
    }

}
