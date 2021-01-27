package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

/**
 * @author zhongyu.yzy
 * @date 2021/1/27
 */
public class Jianzhi_32_III_从上到下打印二叉树III {

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
            for (Map.Entry<Integer, List<Integer>> levelValListEntry : levelValListMap.entrySet()) {
                List<Integer> valList = levelValListEntry.getValue();
                if (levelValListEntry.getKey() % 2 == 1) {
                    levelValListList.add(valList);
                } else {
                    Collections.reverse(valList);
                    levelValListList.add(valList);
                }
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
