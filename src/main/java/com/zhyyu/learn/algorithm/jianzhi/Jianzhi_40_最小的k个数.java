package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

public class Jianzhi_40_最小的k个数 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }

            Arrays.sort(arr);

            int cnt = 1;
            List<Integer> result = new ArrayList<>();

            for (int num : arr) {
                result.add(num);
                if (k == cnt) {
                    break;
                }
                cnt++;
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
