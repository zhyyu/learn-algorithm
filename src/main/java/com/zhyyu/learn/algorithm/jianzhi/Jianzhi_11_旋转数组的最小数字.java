package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyu.yzy
 * @date 2021/1/21
 */
public class Jianzhi_11_旋转数组的最小数字 {

    public static void main(String[] args) {
        int[] numArr = new int[]{3, 4, 5, 1, 2};
        System.out.println(new Solution().minArray(numArr));
    }

    static class Solution {
        public int minArray(int[] numbers) {
            List<Integer> numList = new ArrayList<>();
            for (int num : numbers) {
                numList.add(num);
            }

            if (isSequential(numList)) {
                return numList.get(0);
            }

            int rotateMinimalNum = numList.get(numList.size() - 1);
            while (!isSequential(numList)) {
                rotateMinimalNum = numList.get(numList.size() - 1);
                numList.remove(numList.size() - 1);
            }

            return rotateMinimalNum;
        }

        private boolean isSequential(List<Integer> numList) {
            int firstValue = numList.get(0);
            int preValue = firstValue;
            for (int i = 1; i < numList.size(); i++) {
                int currentValue = numList.get(i);
                if (currentValue < preValue) {
                    return false;
                }
                preValue = currentValue;
            }
            return true;
        }
    }

}
