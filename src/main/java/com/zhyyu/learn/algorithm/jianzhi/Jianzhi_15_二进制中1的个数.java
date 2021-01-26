package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 * @see https://github.com/CyC2018/CS-Notes/blob/master/notes/15.%20%E4%BA%8C%E8%BF%9B%E5%88%B6%E4%B8%AD%201%20%E7%9A%84%E4%B8%AA%E6%95%B0.md
 */
public class Jianzhi_15_二进制中1的个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-3));
    }

    public static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            while (n != 0) {
                cnt ++;
                n = n & (n - 1);
            }
            return cnt;
        }
    }

}
