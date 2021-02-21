package com.zhyyu.learn.algorithm.jianzhi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jianzhi_59_I_滑动窗口的最大值 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[]{};
            }

            List<Integer> maxSlideVal = new ArrayList<>();
            for (int i = 0; i + k <= nums.length; i++) {
                List<Integer> slideVal = new ArrayList<>();
                for (int j = i; j < i + k; j++) {
                    slideVal.add(nums[j]);
                }

                maxSlideVal.add(Collections.max(slideVal));
            }

            return maxSlideVal.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
