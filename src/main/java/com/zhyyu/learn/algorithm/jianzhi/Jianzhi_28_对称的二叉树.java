package com.zhyyu.learn.algorithm.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhongyu.yzy
 * @date 2021/1/26
 */
public class Jianzhi_28_对称的二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode3= new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode44 = new TreeNode(4);
        TreeNode treeNode33 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode22;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode22.left = treeNode44;
        treeNode22.right = treeNode33;

        System.out.println(new Solution().isSymmetric(treeNode1));
    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            TreeNode rootMirror = mirrorTree(root);
            boolean isEqual = isEqual(root, rootMirror);
            return isEqual;
        }

        private boolean isEqual(TreeNode treeA, TreeNode treeB) {
            if (treeA == null && treeB == null) {
                return true;
            }

            if (treeA == null && treeB != null) {
                return false;
            }

            if (treeA != null && treeB == null) {
                return false;
            }

            if (treeA.left == null && treeB.left != null) {
                return false;
            }

            if (treeA.left != null && treeB.left == null) {
                return false;
            }

            if ((treeA.left != null && treeB.left != null) && (treeA.left.val != treeB.left.val)) {
                return false;
            }

            if (treeA.right == null && treeB.right != null) {
                return false;
            }

            if (treeA.right != null && treeB.right == null) {
                return false;
            }

            if ((treeA.right != null && treeB.right != null) && (treeA.right.val != treeB.right.val)) {
                return false;
            }

            return isEqual(treeA.left, treeB.left) && isEqual(treeA.right, treeB.right);
        }

        private TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode tmpRoot = deepCopyNode(root);
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            bfsQueue.add(tmpRoot);
            while (!bfsQueue.isEmpty()) {
                TreeNode node = bfsQueue.poll();
                if (node == null) {
                    continue;
                }

                TreeNode leftTmp = node.left;
                node.left = deepCopyNode(node.right);
                node.right = deepCopyNode(leftTmp);

                bfsQueue.add(node.left);
                bfsQueue.add(node.right);
            }

            return tmpRoot;
        }

        private TreeNode deepCopyNode(TreeNode treeNode) {
            if (treeNode == null) {
                return null;
            }

            TreeNode copiedNode = new TreeNode(treeNode.val);
            copiedNode.left = treeNode.left;
            copiedNode.right = treeNode.right;

            return copiedNode;
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
