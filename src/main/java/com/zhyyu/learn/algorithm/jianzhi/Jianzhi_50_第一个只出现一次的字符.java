package com.zhyyu.learn.algorithm.jianzhi;

import java.util.LinkedHashMap;
import java.util.Map;

public class Jianzhi_50_第一个只出现一次的字符 {

    public static void main(String[] args) {

    }

    static class Solution {
        public char firstUniqChar(String s) {
            char[] chars = s.toCharArray();

            LinkedHashMap<String, Integer> charCnt = new LinkedHashMap<>();
            for (char aChar : chars) {
                Integer cnt = charCnt.get(aChar + "");
                if (cnt == null) {
                    charCnt.put(aChar + "", 1);
                } else {
                    charCnt.put(aChar + "", cnt + 1);
                }
            }

            for (Map.Entry<String, Integer> charCntEntry : charCnt.entrySet()) {
                if (charCntEntry.getValue() == 1) {
                    return charCntEntry.getKey().charAt(0);
                }
            }

            return " ".charAt(0);
        }
    }

}
