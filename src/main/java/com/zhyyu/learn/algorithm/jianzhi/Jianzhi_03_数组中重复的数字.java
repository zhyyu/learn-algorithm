package com.zhyyu.learn.algorithm.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyu.yzy
 * @date 2021/1/20
 */
public class Jianzhi_03_数组中重复的数字 {

    public static void main(String[] args) {
        int repeatNumber = findRepeatNumber(new int[]{1, 2, 2});
        System.out.println(repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            if (numCountMap.containsKey(Integer.valueOf(num))) {
                return num;
            } else {
                numCountMap.put(num, 1);
            }
        }

        return -1;
    }

}
