package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/27
 */
public class Jianzhi_33_二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().verifyPostorder(new int[] {4, 8, 6, 12, 16, 14, 10}));
        System.out.println(new Solution().verifyPostorder(new int[] {1,2,5,10,6,9,4,3}));
    }

    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return verifyPostorder(0, postorder.length, postorder);
        }

        // fromIndex inclusive
        private boolean verifyPostorder(int formIndex, int length, int[] postorder) {
            if (length == 0) {
                return true;
            }

            if (length == 1) {
                return true;
            }

            if (length == 2) {
                return true;
            }

            int midVal = postorder[formIndex + length - 1];

            // midVal 之前全部小于 midVal 之后全部大于midVal
            int biggerIndex = formIndex;
            for (; biggerIndex < formIndex + length - 1; biggerIndex++) {
                if (postorder[biggerIndex] > midVal) {
                    break;
                }
            }

            for (int j = biggerIndex; j < formIndex + length - 1; j++) {
                if (postorder[j] < midVal) {
                    return false;
                }
            }

            return verifyPostorder(formIndex, (biggerIndex - formIndex), postorder) && verifyPostorder(biggerIndex, (length - 1 - (biggerIndex - formIndex)), postorder);
        }
    }

}
