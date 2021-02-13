package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jianzhi_41_数据流中的中位数 {

    public static void main(String[] args) {

    }

    static class MedianFinder {

        private List<Integer> sortedNumList = new ArrayList<>();

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            sortedNumList.add(num);
            Collections.sort(sortedNumList);
        }

        public double findMedian() {
            if (sortedNumList.size() == 0) {
                return 0;
            }

            int size = sortedNumList.size();

            // 0 1 2
            if (size % 2 == 1) {
                return sortedNumList.get(size / 2);
            }

            // 0 1 2 3
            return (sortedNumList.get(size / 2) + sortedNumList.get(size / 2 - 1)) / 2.0;
        }
    }

}
