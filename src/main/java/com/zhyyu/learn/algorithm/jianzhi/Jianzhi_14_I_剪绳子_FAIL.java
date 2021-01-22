package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhongyu.yzy
 * @date 2021/1/22
 */
public class Jianzhi_14_I_剪绳子_FAIL {

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }

    // 5 以下数据不可此拆分（才分之后无法增长乘积）
    static class Solution {
        public int cuttingRope(int n) {
            if (n == 2) {
                return 1;
            }

            if (n == 3) {
                return 2;
            }

            if (n == 4) {
                return 4;
            }

            boolean canCut = true;
            PossibleCutResult prePossibleCutResult = new PossibleCutResult(1, Arrays.asList(new SingleCut(Arrays.asList(n))));

            int maxCutSegMultiply = n;

            while (canCut) {
                // 第一次切分
                if (prePossibleCutResult.segNum == 1) {
                    canCut = false;
                    List<SingleCut> singleCutList = new ArrayList<>();
                    for (int i = 2 ; i <= n / 2; i++) {
                        if (i >= 5 || (n - i) >= 5) {
                            canCut = true;
                        }
                        if (i * (n - i) > maxCutSegMultiply) {
                            maxCutSegMultiply = i * (n - i);
                        }

                        SingleCut singleCut = new SingleCut(Arrays.asList(i, n - i));
                        singleCutList.add(singleCut);
                    }

                    prePossibleCutResult.segNum = 2;
                    prePossibleCutResult.singleCutList = singleCutList;
                    continue;
                }

                // 非第一次切分
                List<SingleCut> nextSingleCutList = new ArrayList<>();
                canCut = false;
                for (SingleCut singleCut : prePossibleCutResult.singleCutList) {
                    List<Integer> cutSegList = singleCut.cutSegList;

                    // 是否可切分
                    Integer maxSeg = Collections.max(cutSegList);
                    if (maxSeg >= 5) {
                        canCut = true;
                        List<Integer> splitSegList = new ArrayList<>();
                        splitSegList.addAll(cutSegList);
                        splitSegList.remove(maxSeg);
                        // TODO: juror 2021/1/22 该处有问题？ 仅保证了下一次切分最大，为贪心算法， 不保证正确
                        // 9 = 4 + 2 + 3；9 = 3 + 3 + 3 // 3 越多越好
                        if (maxSeg % 2 == 0) {
                            splitSegList.add(maxSeg / 2);
                            splitSegList.add(maxSeg / 2);
                        } else {
                            splitSegList.add(maxSeg / 2);
                            splitSegList.add(maxSeg / 2 + 1);
                        }

                        if (multiplySeg(splitSegList) > maxCutSegMultiply) {
                            maxCutSegMultiply = multiplySeg(splitSegList);
                        }

                        nextSingleCutList.add(new SingleCut(splitSegList));
                    }
                }

                prePossibleCutResult.segNum += 1;
                prePossibleCutResult.singleCutList = nextSingleCutList;
            }

            return maxCutSegMultiply;
        }

        private int multiplySeg(List<Integer> segList) {
            int result = 1;
            for (Integer seg : segList) {
                result = result * seg;
            }
            return result;
        }

        static class PossibleCutResult {
            int segNum;
            List<SingleCut> singleCutList;

            public PossibleCutResult(int segNum, List<SingleCut> singleCutList) {
                this.segNum = segNum;
                this.singleCutList = singleCutList;
            }
        }

        static class SingleCut {
            List<Integer> cutSegList;

            public SingleCut(List<Integer> cutSegList) {
                this.cutSegList = cutSegList;
            }
        }

    }

}
