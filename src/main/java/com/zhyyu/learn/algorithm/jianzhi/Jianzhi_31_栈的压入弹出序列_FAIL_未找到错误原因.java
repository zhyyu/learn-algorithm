package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

/**
 * @author zhongyu.yzy
 * @date 2021/1/26
 */
public class Jianzhi_31_栈的压入弹出序列_FAIL_未找到错误原因 {

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    static class Solution {

        private boolean matched = false;
        private List<Integer> targetPopped = new ArrayList<>();

        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Queue<Integer> pushQueue = new LinkedList<>();
            for (int i = 0; i < pushed.length; i++) {
                pushQueue.add(pushed[i]);
            }

            for (int i = 0; i < popped.length; i++) {
                targetPopped.add(popped[i]);
            }

            consumeQueue(pushQueue, new Stack<>(), new ArrayList<>());
            return matched;
        }

        public void consumeQueue(Queue<Integer> pushQueue, Stack<Integer> stackVal, List<Integer> popResult) {
            boolean targetContains = targetContains(popResult);
            if (!targetContains) {
                return;
            }

            if (!pushQueue.isEmpty()) {
                // push
                Queue<Integer> copiedQueue = copyQueue(pushQueue);
                Stack<Integer> copiedStack = copyStack(stackVal);
                List<Integer> copiedPopResult = copyList(popResult);

                Integer popVal = copiedQueue.poll();
                copiedStack.push(popVal);
                consumeQueue(copiedQueue, copiedStack, copiedPopResult);
            }

            if (!stackVal.isEmpty()) {
                // pop
                Queue<Integer> copiedQueue2 = copyQueue(pushQueue);
                Stack<Integer> copiedStack2 = copyStack(stackVal);
                List<Integer> copiedPopResult = copyList(popResult);

                Integer popVal = copiedStack2.pop();
                copiedPopResult.add(popVal);
                consumeQueue(copiedQueue2, copiedStack2, copiedPopResult);
            }

            if (pushQueue.isEmpty() && stackVal.isEmpty()) {
                boolean isEqual = isEqual(popResult, targetPopped);
                System.out.println(popResult);
                if (isEqual) {
                    matched = true;
                }
            }
            return;
        }

        private boolean targetContains(List<Integer> popResult) {
            for (int i = 0; i < popResult.size(); i++) {
                if (popResult.get(i) != targetPopped.get(i)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isEqual(List<Integer> popResult, List<Integer> targetPopped) {
            String popResultStr = "";
            for (Integer val : popResult) {
                popResultStr += val + ",";
            }

            String targetPopStr = "";
            for (Integer val : targetPopped) {
                targetPopStr += val + ",";
            }

            return popResultStr.equals(targetPopStr);
        }

        private List<Integer> copyList(List<Integer> popResult) {
            List<Integer> copiedList = new ArrayList<>();
            for (Integer val : popResult) {
                copiedList.add(val);
            }

            return copiedList;
        }

        private Queue<Integer> copyQueue(Queue<Integer> queue) {
            Queue<Integer> resultQueue = new LinkedList<>();
            for (Integer val : queue) {
                resultQueue.add(val);
            }

            return resultQueue;
        }

        private Stack<Integer> copyStack(Stack<Integer> stackVal) {
            Stack<Integer> resultStack = new Stack<>();
            for (Integer val : stackVal) {
                resultStack.add(val);
            }

            return resultStack;
        }
    }

}
