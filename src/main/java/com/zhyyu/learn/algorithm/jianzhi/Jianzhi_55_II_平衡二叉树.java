package com.zhyyu.learn.algorithm.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

public class Jianzhi_55_II_平衡二叉树 {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue<TreeNode> bfs = new LinkedList<>();
            bfs.add(root);
            while (!bfs.isEmpty()) {
                TreeNode node = bfs.poll();
                int deepDiff = maxDepth(node.left) - maxDepth(node.right);
                if (deepDiff > 1 || deepDiff < -1) {
                    return false;
                }

                if (node.left != null) {
                    bfs.add(node.left);
                }

                if (node.right != null) {
                    bfs.add(node.right);
                }
            }

            return true;
        }

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
