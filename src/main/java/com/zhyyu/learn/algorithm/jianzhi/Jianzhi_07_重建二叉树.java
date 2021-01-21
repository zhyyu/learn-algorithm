package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongyu.yzy
 * @date 2021/1/20
 * @see https://github.com/CyC2018/CS-Notes/blob/master/notes/7.%20%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91.md
 */
public class Jianzhi_07_重建二叉树 {

/*    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]*/

    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            indexForInOrders.put(inorder[i], i);
        return reConstructBinaryTree(preorder, 0, preorder.length - 1, 0);
    }

    private static TreeNode reConstructBinaryTree(int[] preorder, int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        Integer inOrderIndex = indexForInOrders.get(preorder[preLeft]);
        int leftTreeSize = inOrderIndex - inLeft;
        root.left = reConstructBinaryTree(preorder, preLeft + 1, preLeft + leftTreeSize, inLeft);
        root.right = reConstructBinaryTree(preorder, preLeft + leftTreeSize + 1, preRight, inLeft + leftTreeSize + 1);

        return root;
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
