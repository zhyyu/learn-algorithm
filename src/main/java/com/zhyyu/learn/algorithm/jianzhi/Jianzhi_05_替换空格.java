package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/20
 */
public class Jianzhi_05_替换空格 {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        String result = "";

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                result += "%20";
            } else {
                result += aChar;
            }
        }

        return result;
    }

}
