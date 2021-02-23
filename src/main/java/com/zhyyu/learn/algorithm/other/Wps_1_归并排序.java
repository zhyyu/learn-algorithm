package com.zhyyu.learn.algorithm.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Wps_1_归并排序 {

    public Wps_1_归并排序() {
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 5};
        int[] nums2 = new int[] {3, 4};

        int[] resultNums = new Solution().merge(nums1, nums2);
        for (int i = 0; i < resultNums.length; i++) {
            System.out.println(resultNums[i]);
        }
    }

    // 归并排序
    public static class Solution {
        public int[] merge(int[] nums1, int[] nums2) {
            Queue<Integer> queue1 = new LinkedList<>();
            for (int i = 0; i < nums1.length; i++) {
                queue1.add(nums1[i]);
            }

            Queue<Integer> queue2 = new LinkedList<>();
            for (int i = 0; i < nums2.length; i++) {
                queue2.add(nums2[i]);
            }

            List<Integer> resultList = new ArrayList<>();
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                Integer queue1Min = queue1.peek();
                Integer queue2Min = queue2.peek();

                if (queue1Min == null) {
                    queue2.poll();
                    resultList.add(queue2Min);
                    continue;
                }

                if (queue2Min == null) {
                    queue1.poll();
                    resultList.add(queue1Min);
                    continue;
                }

                if (queue1Min <= queue2Min) {
                    queue1.poll();
                    resultList.add(queue1Min);
                } else {
                    queue2.poll();
                    resultList.add(queue2Min);
                }
            }

            return resultList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
