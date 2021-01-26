package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Stack;

/**
 * @author zhongyu.yzy
 * @date 2021/1/26
 * @see https://github.com/CyC2018/CS-Notes/blob/master/notes/30.%20%E5%8C%85%E5%90%AB%20min%20%E5%87%BD%E6%95%B0%E7%9A%84%E6%A0%88.md
 */
public class Jianzhi_30_包含min函数的栈 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.min();
        minStack.pop();
        int top = minStack.top();
        int min1 = minStack.min();
    }

    static class MinStack {

        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(x, minStack.peek()));
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

}
