package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

/**
 * @author zhongyu.yzy
 * @date 2021/1/27
 */
public class Jianzhi_32_II_从上到下打印二叉树II {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        System.out.println(new Solution().levelOrder(treeNode3));
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>(new ArrayList<>());
            }

            // bfs
            Queue<MyTreeNode> bfsQueue = new LinkedList<>();
            bfsQueue.add(new MyTreeNode(root, 1));

            TreeMap<Integer, List<Integer>> levelValListMap = new TreeMap<>();
            while (!bfsQueue.isEmpty()) {
                MyTreeNode node = bfsQueue.poll();

                List<Integer> valList = levelValListMap.get(node.level);
                if (valList == null) {
                    valList = new ArrayList<>();
                }
                valList.add(node.val);
                levelValListMap.put(node.level, valList);

                if (node.left != null) {
                    bfsQueue.add(new MyTreeNode(node.left, node.level + 1));
                }
                if (node.right != null) {
                    bfsQueue.add(new MyTreeNode(node.right, node.level + 1));
                }
            }

            List<List<Integer>> levelValListList = new ArrayList<>();
            for (List<Integer> values : levelValListMap.values()) {
                levelValListList.add(values);
            }
            return levelValListList;
        }

        public static class MyTreeNode extends TreeNode {
            int level;

            public MyTreeNode(TreeNode treeNode, int level) {
                super(treeNode.val);
                this.left = treeNode.left;
                this.right = treeNode.right;
                this.level = level;
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
