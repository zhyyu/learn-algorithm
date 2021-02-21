package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Jianzhi_58_I_翻转单词顺序 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(" a good   example "));
    }

    static class Solution {
        public String reverseWords(String s) {
            String[] splitBySpace = s.split(" ");
            List<String> wordList = Arrays.asList(splitBySpace).stream().filter(str -> str.length() > 0).collect(Collectors.toList());
            Collections.reverse(wordList);

            String result = "";
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);
                if (i != wordList.size() - 1) {
                    result = result + word + " ";
                } else {
                    result = result + word;
                }
            }

            return result;
        }
    }

}
