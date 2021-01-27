package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhongyu.yzy
 * @date 2021/1/27
 */
public class Jianzhi_32_I_从上到下打印二叉树 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }

            // bfs
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            bfsQueue.add(root);

            List<Integer> resultList = new ArrayList<>();
            while (!bfsQueue.isEmpty()) {
                TreeNode node = bfsQueue.poll();
                resultList.add(node.val);
                if (node.left != null) {
                    bfsQueue.add(node.left);
                }
                if (node.right != null) {
                    bfsQueue.add(node.right);
                }
            }

            return resultList.stream().mapToInt(Integer::intValue).toArray();
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
