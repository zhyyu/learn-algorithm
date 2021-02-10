package com.zhyyu.learn.algorithm.jianzhi;

import java.util.HashMap;
import java.util.Map;

public class Jianzhi_39_数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int length = nums.length;
            Map<Integer, Integer> numCnt = new HashMap<>();
            for (int num : nums) {
                Integer result = numCnt.get(num);
                if (result == null) {
                    numCnt.put(num, 1);
                    if (1 > length / 2) {
                        return num;
                    }
                } else {
                    numCnt.put(num, result + 1);
                    if (result + 1 > length / 2) {
                        return num;
                    }
                }
            }

            return -1;
        }
    }

}
