package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

/**
 * @author zhongyu.yzy
 * @date 2021/1/28
 */
public class Jianzhi_34_二叉树中和为某一值的路径 {

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_2 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5_2 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_2;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode4_2.left = treeNode5_2;
        treeNode4_2.right = treeNode1;

        System.out.println(new Solution().pathSum(treeNode5, 22));
    }

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            Queue<MyTreeNode> bfsQueue = new LinkedList<>();
            if (root == null) {
                return new ArrayList<>(new ArrayList<>());
            }

            List<List<Integer>> pathList = new ArrayList<>();
            bfsQueue.add(new MyTreeNode(root, root.val, null));
            while (!bfsQueue.isEmpty()) {
                MyTreeNode preNode = bfsQueue.poll();
                // 必须为叶子结点
                if (preNode.sum == sum && preNode.left == null && preNode.right == null) {
                    List<Integer> path = buildPath(preNode);
                    pathList.add(path);
                    continue;
                }

                if (preNode.sum == sum && (preNode.left != null || preNode.right != null)) {
                    if (preNode.left != null) {
                        MyTreeNode leftTreeNode = new MyTreeNode(preNode.left, preNode.sum + preNode.left.val, preNode);
                        bfsQueue.add(leftTreeNode);
                    }

                    if (preNode.right != null) {
                        MyTreeNode rightTreeNode = new MyTreeNode(preNode.right, preNode.sum + preNode.right.val, preNode);
                        bfsQueue.add(rightTreeNode);
                    }
                    continue;
                }


                if (preNode.sum != sum) {
                    if (preNode.left != null) {
                        MyTreeNode leftTreeNode = new MyTreeNode(preNode.left, preNode.sum + preNode.left.val, preNode);
                        bfsQueue.add(leftTreeNode);
                    }

                    if (preNode.right != null) {
                        MyTreeNode rightTreeNode = new MyTreeNode(preNode.right, preNode.sum + preNode.right.val, preNode);
                        bfsQueue.add(rightTreeNode);
                    }
                }
            }

            return pathList;
        }

        private List<Integer> buildPath(MyTreeNode node) {
            List<Integer> path = new ArrayList<>();
            while (node.preNode != null) {
                path.add(node.val);
                node = node.preNode;
            }

            path.add(node.val);
            Collections.reverse(path);
            return path;
        }

        static class MyTreeNode extends TreeNode {

            int sum;
            MyTreeNode preNode;

            MyTreeNode(TreeNode treeNode, int sum, MyTreeNode preNode) {
                super(treeNode.val);
                this.left = treeNode.left;
                this.right = treeNode.right;
                this.sum = sum;
                this.preNode = preNode;
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
