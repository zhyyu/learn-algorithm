package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

public class Jianzhi_49_丑数 {

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            List<Integer> uglyNumList = new ArrayList<>();
            uglyNumList.add(1);
            uglyNumList.add(2);
            uglyNumList.add(3);
            uglyNumList.add(4);
            uglyNumList.add(5);
            if (n <= 5) {
                return uglyNumList.get(n - 1);
            }

            int[] multiplierArr = {2, 3, 5};
            while (true) {
                int maxUglyNum = uglyNumList.get(uglyNumList.size() - 1);

                List<Integer> newUglyNumList = new ArrayList<>();
                for (int multiplier : multiplierArr) {
                    for (Integer uglyNum : uglyNumList) {
                        if (uglyNum * multiplier > maxUglyNum) {
                            newUglyNumList.add(uglyNum * multiplier);
                            break;
                        }
                    }
                }

                Integer nextUglyNum = newUglyNumList.stream().min(Comparator.comparingInt(i -> i)).get();
                uglyNumList.add(nextUglyNum);
                if (uglyNumList.size() >= n) {
                    return uglyNumList.get(n - 1);
                }
            }
        }
    }

}
