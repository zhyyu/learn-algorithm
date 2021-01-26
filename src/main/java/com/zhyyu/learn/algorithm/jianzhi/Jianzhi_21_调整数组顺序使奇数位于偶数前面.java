package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_21_调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int[] nums = new int[] {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        int[] exchange = new Solution().exchange(nums);
        for (int i : exchange) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] exchange(int[] nums) {
            int j = nums.length - 1;

            for (int i = 0; i < nums.length; i++) {
                // 奇数， 无序交换
                if (nums[i] % 2 == 1) {
                    continue;
                }

                // 偶数， 交互逆序第一个奇数
                if (nums[i] % 2 == 0) {
                    for (; j > i; j--) {
                        if (nums[j] % 2 == 1) {
                            int tmp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = tmp;
                            j--;
                            break;
                        }
                    }
                }
            }

            return nums;
        }
    }

}
