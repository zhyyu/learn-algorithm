package com.zhyyu.learn.algorithm.jianzhi;

public class Jianzhi_54_二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode1.right = treeNode2;

//        new Solution().reverseOrder(treeNode3);
        System.out.println(new Solution().kthLargest(treeNode3, 1));

    }

    static class Solution {

        private int currentCnt = 0;
        private int targetCnt;
        private int targetVal;

        public int kthLargest(TreeNode root, int k) {
            this.targetCnt = k;
            reverseOrder(root);
            return targetVal;
        }

        public void reverseOrder(TreeNode root) {
            if (root == null) {
                return;
            }

            reverseOrder(root.right);
            currentCnt++;

            if (currentCnt > targetCnt) {
                return;
            }

            if (currentCnt == targetCnt) {
                this.targetVal = root.val;
                return;
            }
            System.out.println(root.val);
            reverseOrder(root.left);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
