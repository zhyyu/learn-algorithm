package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_48_最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }

            int maxSubStringLength = 1;
            int fromIndex = 0;

            int currentLength = 1;
            for (int i = 1; i < s.length(); i++) {
                if (!s.substring(fromIndex, i).contains(s.charAt(i) + "")) {
                    currentLength++;
                    if (currentLength > maxSubStringLength) {
                        maxSubStringLength = currentLength;
                    }
                    continue;
                }

                int duplicateIndex = s.substring(0, i).lastIndexOf(s.charAt(i) + "");
                fromIndex = duplicateIndex + 1;
                currentLength = i - duplicateIndex;
            }

            return maxSubStringLength;
        }
    }

}
