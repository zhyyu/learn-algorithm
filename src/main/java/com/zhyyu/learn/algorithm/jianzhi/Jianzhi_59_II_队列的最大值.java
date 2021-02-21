package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Jianzhi_59_II_队列的最大值 {

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }

    static class MaxQueue {

        private Deque<Integer> tmpDeque = new LinkedList<>();
        private Queue<Integer> queue = new LinkedList<>();

        public MaxQueue() {
        }

        public int max_value() {
            if (tmpDeque.isEmpty()) {
                return -1;
            }

            return tmpDeque.peek();
        }

        public void push_back(int value) {
            queue.add(value);

            while (tmpDeque.peekLast() != null && tmpDeque.peekLast() < value) {
                tmpDeque.pollLast();
            }
            tmpDeque.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }

            Integer pollVal = queue.poll();
            if (pollVal.equals(tmpDeque.peek())) {
                tmpDeque.poll();
            }

            return pollVal;
        }
    }

}
