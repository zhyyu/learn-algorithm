package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhongyu.yzy
 * @date 2021/1/26
 */
public class Jianzhi_26_树的子结构 {

    public static void main(String[] args) {
        TreeNode treeNodeA3 = new TreeNode(3);
        TreeNode treeNodeA4 = new TreeNode(4);
        TreeNode treeNodeA5 = new TreeNode(5);
        TreeNode treeNodeA1 = new TreeNode(1);
        TreeNode treeNodeA2 = new TreeNode(2);

        treeNodeA3.left = treeNodeA4;
        treeNodeA3.right = treeNodeA5;
        treeNodeA4.left = treeNodeA1;
        treeNodeA4.right = treeNodeA2;

        TreeNode treeNodeB4 = new TreeNode(4);
        TreeNode treeNodeB1 = new TreeNode(1);
        treeNodeB4.left = treeNodeB1;

        TreeNode rootA = treeNodeA3;
        TreeNode rootB = treeNodeB4;

        System.out.println(new Solution().isSubStructure(rootA, rootB));
    }

    static class Solution {
        private List<TreeNode> bRootInAList = new ArrayList<>();

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            findBRootInA(A, B);
            for (TreeNode bRootInA : bRootInAList) {
                boolean aContainsB = aContainsB(bRootInA, B);
                if (aContainsB) {
                    return true;
                }
            }
            return false;
        }

        private boolean aContainsB(TreeNode bRootInA, TreeNode b) {
            // 类似广度优先搜索比较， 使用队列
            Queue<TreeNode> bQueue = new LinkedList<>();
            Queue<TreeNode> aQueue = new LinkedList<>();

            bQueue.add(b.left);
            bQueue.add(b.right);

            aQueue.add(bRootInA.left);
            aQueue.add(bRootInA.right);

            while (!bQueue.isEmpty()) {
                TreeNode bNode = bQueue.poll();
                TreeNode aNode = aQueue.poll();

                if (bNode == null) {
                    continue;
                }

                if (aNode == null) {
                    return false;
                }

                if (bNode.val != aNode.val) {
                    return false;
                }

                bQueue.add(bNode.left);
                bQueue.add(bNode.right);

                aQueue.add(aNode.left);
                aQueue.add(aNode.right);
            }

            return true;
        }

        private void findBRootInA(TreeNode a, TreeNode bRoot) {
            if (a == null) {
                return;
            }

            if (bRoot == null) {
                return;
            }

            if (a.val == bRoot.val) {
                bRootInAList.add(a);
            }
            findBRootInA(a.left, bRoot);
            findBRootInA(a.right, bRoot);
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
