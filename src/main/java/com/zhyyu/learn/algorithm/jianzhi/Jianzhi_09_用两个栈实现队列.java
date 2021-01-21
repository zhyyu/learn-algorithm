package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Stack;

/**
 * @author zhongyu.yzy
 * @date 2021/1/21
 */
public class Jianzhi_09_用两个栈实现队列 {


    static class CQueue {

        private Stack<Integer> inputStack = new Stack<>();
        private Stack<Integer> outputStack = new Stack<>();

        public CQueue() {
        }

        public void appendTail(int value) {
            inputStack.push(value);

        }

        public int deleteHead() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
                if (outputStack.isEmpty()) {
                    return -1;
                } else {
                    return outputStack.pop();
                }
            } else {
                return outputStack.pop();
            }
        }
    }

}
