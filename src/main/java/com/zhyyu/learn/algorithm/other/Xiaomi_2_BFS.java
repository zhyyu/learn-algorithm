package com.zhyyu.learn.algorithm.other;

import java.util.LinkedList;
import java.util.Queue;

public class Xiaomi_2_BFS {

    public static void main(String[] args) {
        System.out.println(new Solution().func(4, 6));
    }

    static class Solution {

        private int MULTIPLY_TWO = 1;
        private int DECR_ONE = 2;

        int func(int a, int b) {
            Queue<BfsNode> bfsQueue = new LinkedList<>();
            bfsQueue.add(new BfsNode(a, MULTIPLY_TWO, 1));
            bfsQueue.add(new BfsNode(a, DECR_ONE, 1));

            while (!bfsQueue.isEmpty()) {
                BfsNode bfsNode = bfsQueue.poll();
                if (bfsNode.preVal == b) {
                    return bfsNode.deep - 1;
                }

                if (bfsNode.operator == MULTIPLY_TWO) {
                    BfsNode newMultiplyTwoNode = new BfsNode(bfsNode.preVal * 2, MULTIPLY_TWO, bfsNode.deep + 1);
                    BfsNode newDecrNode = new BfsNode(bfsNode.preVal * 2, DECR_ONE, bfsNode.deep + 1);
                    bfsQueue.add(newMultiplyTwoNode);
                    bfsQueue.add(newDecrNode);
                    continue;
                }

                if (bfsNode.operator == DECR_ONE) {
                    BfsNode newMultiplyTwoNode = new BfsNode(bfsNode.preVal - 1, MULTIPLY_TWO, bfsNode.deep + 1);
                    BfsNode newDecrNode = new BfsNode(bfsNode.preVal -1 , DECR_ONE, bfsNode.deep + 1);
                    bfsQueue.add(newMultiplyTwoNode);
                    bfsQueue.add(newDecrNode);
                    continue;
                }
            }

            return -1;
        }

        static class BfsNode {
            int preVal;
            int operator;
            int deep;

            public BfsNode(int preVal, int operator, int deep) {
                this.preVal = preVal;
                this.operator = operator;
                this.deep = deep;
            }
        }

    }

}
