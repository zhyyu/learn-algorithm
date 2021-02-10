package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

public class Jianzhi_37_序列化二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        System.out.println(new Codec().serialize(treeNode1));

        // deserialize
//        TreeNode deserializedTree = new Codec().deserialize("[1,2,3,null,null,4,5]");
//        TreeNode deserializedTree = new Codec().deserialize("[]");
//        TreeNode deserializedTree = new Codec().deserialize("[1,2]");
        TreeNode deserializedTree = new Codec().deserialize("[3,2,4,1]");
        System.out.println(deserializedTree);
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            if (root == null) {
                return "[]";
            }

            List<Integer> valList = new ArrayList<>();
            bfsQueue.add(root);
            while (!bfsQueue.isEmpty()) {
                TreeNode node = bfsQueue.poll();
                if (node == null) {
                    valList.add(null);
                    continue;
                }

                valList.add(node.val);
                bfsQueue.add(node.left);
                bfsQueue.add(node.right);
            }

            // 去除尾部null
            int toIndex = valList.size();
            for (int j = valList.size() - 1; j >= 0; j--) {
                if (valList.get(j) != null) {
                    break;
                }

                toIndex = j;
            }

            valList = valList.subList(0, toIndex);
            return valList.toString().replace(" ", "");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] splitValArr = data.substring(1, data.length() - 1).split(",");
            if (splitValArr.length == 1 && splitValArr[0].equals("")) {
                return null;
            }
            Queue<String> bfsQueue = new LinkedList<>();

            for (String val : splitValArr) {
                bfsQueue.add(val);
            }

            TreeNode root = new TreeNode(Integer.valueOf(bfsQueue.poll()));
            List<TreeNode> nextLayer = new ArrayList<>();
            nextLayer.add(root);
            while (!bfsQueue.isEmpty()) {
                List<TreeNode> newNextLayer = new ArrayList<>();

                for (TreeNode treeNode : nextLayer) {
                    String leftVal = bfsQueue.poll();
                    if (leftVal == null) {
                        continue;
                    }
                    if (!"null".equals(leftVal)) {
                        TreeNode leftNode = new TreeNode(Integer.valueOf(leftVal));
                        treeNode.left = leftNode;
                        newNextLayer.add(leftNode);
                    }

                    String rightVal = bfsQueue.poll();
                    if (rightVal == null) {
                        continue;
                    }
                    if (!"null".equals(rightVal)) {
                        TreeNode rightNode = new TreeNode(Integer.valueOf(rightVal));
                        treeNode.right = rightNode;
                        newNextLayer.add(rightNode);
                    }
                }

                nextLayer = newNextLayer;
            }

            return root;
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
