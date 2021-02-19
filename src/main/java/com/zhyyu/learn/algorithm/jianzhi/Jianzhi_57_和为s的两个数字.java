package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_57_和为s的两个数字 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            while (j - i >= 1) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{nums[i], nums[j]};
                }

                if (target < nums[i] + nums[j]) {
                    j = j - 1;
                }

                if (target > nums[i] + nums[j]) {
                    i = i + 1;
                }
            }

            return new int[]{};
        }
    }

    // 复杂度过高
    // 使用二分查找？
//    static class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length; i++) {
//                int firstNum = nums[i];
//                int secondNum = target - firstNum;
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] == secondNum) {
//                        return new int[]{firstNum, secondNum};
//                    }
//
//                    if (nums[j] > secondNum) {
//                        break;
//                    }
//                }
//            }
//
//            return new int[]{};
//        }
//    }

}
