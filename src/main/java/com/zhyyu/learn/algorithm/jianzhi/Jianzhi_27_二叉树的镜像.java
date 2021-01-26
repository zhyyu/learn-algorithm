package com.zhyyu.learn.algorithm.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhongyu.yzy
 * @date 2021/1/26
 */
public class Jianzhi_27_二叉树的镜像 {

    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            Queue<TreeNode> bfsQueue = new LinkedList<>();
            bfsQueue.add(root);
            while (!bfsQueue.isEmpty()) {
                TreeNode node = bfsQueue.poll();
                if (node == null) {
                    continue;
                }

                TreeNode leftTmp = node.left;
                node.left = node.right;
                node.right = leftTmp;
                bfsQueue.add(node.left);
                bfsQueue.add(node.right);
            }

            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
