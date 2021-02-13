package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_46_把数字翻译成字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
        System.out.println(new Solution().translateNum(506));
    }

    static class Solution {

        private int translateCnt = 0;

        public int translateNum(int num) {
            String numString = num + "";
            dfs(numString);
            return translateCnt;
        }

        private void dfs(String numString) {
            if (numString.length() == 1) {
                translateCnt++;
                return;
            }

            if (numString.length() == 2) {
                Integer twoDigitNum = Integer.valueOf(numString);
                if (twoDigitNum < 10) {
                    translateCnt++;
                    return;
                } else if (twoDigitNum <= 25) {
                    translateCnt = translateCnt + 2;
                    return;
                } else {
                    translateCnt++;
                    return;
                }
            }

            // 取出一个digit
            dfs(numString.substring(1));

            String firstTwoDigits = numString.substring(0, 2);
            Integer twoDigitNum = Integer.valueOf(firstTwoDigits);
            if (twoDigitNum >= 10 && twoDigitNum <= 25) {
                dfs(numString.substring(2));
            }
        }
    }

}
