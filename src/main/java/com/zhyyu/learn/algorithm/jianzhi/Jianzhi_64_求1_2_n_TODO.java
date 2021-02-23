package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_64_求1_2_n_TODO {

    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(9));
    }

    static class Solution {
        public int sumNums(int n) {
            return (1 + n) * n / 2;
        }
    }

}
