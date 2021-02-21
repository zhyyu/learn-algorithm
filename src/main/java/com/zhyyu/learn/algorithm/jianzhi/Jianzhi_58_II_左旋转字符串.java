package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_58_II_左旋转字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseLeftWords("abcdefg", 2));
    }

    static class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n, s.length()) + s.substring(0, n);
        }
    }

}
