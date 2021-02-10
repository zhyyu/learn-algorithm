package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jianzhi_38_字符串的排列 {

    public static void main(String[] args) {
        new Solution().permutation("abc");
    }

    static class Solution {
        public String[] permutation(String s) {
            char[] chars = s.toCharArray();
            List<String> charList = new ArrayList<>();
            for (char aChar : chars) {
                charList.add(aChar + "");
            }

            Set<String> result = new HashSet<>();
            dfs("", charList, result);

            String[] resultArr = result.toArray(new String[result.size()]);
            return resultArr;
        }

        private void dfs(String preStr, List<String> leftCharList, Set<String> result) {
            if (leftCharList.size() == 0) {
                result.add(preStr);
                return;
            }

            for (String aChar : leftCharList) {
                List<String> newLeftCharList = new ArrayList<>(leftCharList);
                newLeftCharList.remove(aChar);
                dfs(preStr + aChar, newLeftCharList, result);
            }
        }

    }

}
