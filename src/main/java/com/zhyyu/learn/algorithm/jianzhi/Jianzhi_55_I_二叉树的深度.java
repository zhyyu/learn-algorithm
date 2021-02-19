package com.zhyyu.learn.algorithm.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

public class Jianzhi_55_I_二叉树的深度 {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        System.out.println(new Solution().maxDepth(treeNode3));
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<MyTreeNode> bfs = new LinkedList<>();
            bfs.add(new MyTreeNode(root, 1));

            int maxDeep = 1;
            while (!bfs.isEmpty()) {
                MyTreeNode treeNode = bfs.poll();
                if (treeNode.deep > maxDeep) {
                    maxDeep = treeNode.deep;
                }
                if (treeNode.left != null) {
                    bfs.add(new MyTreeNode(treeNode.left, treeNode.deep + 1));
                }
                if (treeNode.right != null) {
                    bfs.add(new MyTreeNode(treeNode.right, treeNode.deep + 1));
                }
            }

            return maxDeep;
        }

        static class MyTreeNode extends TreeNode {
            int deep;
            public MyTreeNode(TreeNode treeNode, int deep) {
                super(treeNode.val);
                this.left = treeNode.left;
                this.right = treeNode.right;
                this.deep = deep;
            }
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
