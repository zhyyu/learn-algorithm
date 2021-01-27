package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Stack;

/**
 * @author zhongyu.yzy
 * @date 2021/1/26
 * @see https://github.com/CyC2018/CS-Notes/blob/master/notes/31.%20%E6%A0%88%E7%9A%84%E5%8E%8B%E5%85%A5%E3%80%81%E5%BC%B9%E5%87%BA%E5%BA%8F%E5%88%97.md
 */
public class Jianzhi_31_栈的压入弹出序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed.length == 0 && popped.length == 0) {
                return true;
            }

            if (pushed.length > 0 && popped.length == 0) {
                return false;
            }

            if (pushed.length == 0 && popped.length > 0) {
                return false;
            }

            Stack<Integer> stack = new Stack<>();
            for (int i = 0, j = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && (stack.peek() == popped[j])) {
                    stack.pop();
                    j++;

                    if (stack.isEmpty() && j == popped.length) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

}
