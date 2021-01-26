package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_17_打印从1到最大的n位数 {

    public static void main(String[] args) {
        int[] numArr = new Solution().printNumbers(3);
        for (int i : numArr) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] printNumbers(int n) {
            int maxNum = 1;
            for (int i = 0; i < n; i++) {
                maxNum = maxNum * 10;
            }
            maxNum--;

            int[] numArr = new int[maxNum];
            for (int i = 0; i < maxNum; i++) {
                numArr[i] = i + 1;
            }
            return numArr;
        }
    }

}
