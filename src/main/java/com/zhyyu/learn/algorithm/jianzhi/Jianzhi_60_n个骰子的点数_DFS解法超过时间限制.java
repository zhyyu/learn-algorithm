package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

public class Jianzhi_60_n个骰子的点数_DFS解法超过时间限制 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dicesProbability(12);
    }

    static class Solution {
        public double[] dicesProbability(int n) {
            // dfs 求解
            int possibleCombine = 1;
            for (int i = 1 ; i <= n; i++) {
                possibleCombine = possibleCombine * 6;
            }

            TreeMap<Integer, Integer> sumCntMap = new TreeMap<>();
            Stack<DfsValCnt> dfsStack = new Stack<>();
            dfsStack.push(new DfsValCnt(1, 1));
            dfsStack.push(new DfsValCnt(2, 1));
            dfsStack.push(new DfsValCnt(3, 1));
            dfsStack.push(new DfsValCnt(4, 1));
            dfsStack.push(new DfsValCnt(5, 1));
            dfsStack.push(new DfsValCnt(6, 1));

            while (!dfsStack.isEmpty()) {
                DfsValCnt dfsValCnt = dfsStack.pop();

                if (dfsValCnt.cnt == n) {
                    int sum = calSum(dfsValCnt);
                    if (sumCntMap.get(sum) == null) {
                        sumCntMap.put(sum, 1);
                    } else {
                        sumCntMap.put(sum, sumCntMap.get(sum) + 1);
                    }
                    continue;
                }

                dfsStack.push(new DfsValCnt(1, dfsValCnt.cnt + 1, dfsValCnt));
                dfsStack.push(new DfsValCnt(2, dfsValCnt.cnt + 1, dfsValCnt));
                dfsStack.push(new DfsValCnt(3, dfsValCnt.cnt + 1, dfsValCnt));
                dfsStack.push(new DfsValCnt(4, dfsValCnt.cnt + 1, dfsValCnt));
                dfsStack.push(new DfsValCnt(5, dfsValCnt.cnt + 1, dfsValCnt));
                dfsStack.push(new DfsValCnt(6, dfsValCnt.cnt + 1, dfsValCnt));
            }

            int finalPossibleCombine = possibleCombine;
            return sumCntMap.values().stream().map(cnt -> 1.0 * cnt / finalPossibleCombine).mapToDouble(Double::doubleValue).toArray();
        }

        private int calSum(DfsValCnt dfsValCnt) {
            int sum = 0;
            while (dfsValCnt.preDfsVal != null) {
                sum = sum + dfsValCnt.val;
                dfsValCnt = dfsValCnt.preDfsVal;
            }

            sum = sum + dfsValCnt.val;
            return sum;
        }

        class DfsValCnt {
            int val;
            int cnt;

            DfsValCnt preDfsVal;

            public DfsValCnt(int val, int cnt) {
                this.val = val;
                this.cnt = cnt;
            }

            public DfsValCnt(int val, int cnt, DfsValCnt preDfsVal) {
                this.val = val;
                this.cnt = cnt;
                this.preDfsVal = preDfsVal;
            }
        }
    }

}
