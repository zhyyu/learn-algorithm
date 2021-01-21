package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhongyu.yzy
 * @date 2021/1/20
 */
public class Jianzhi_07_重建二叉树_FAIL {

/*    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]*/

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        TreeNode preNode = null;
        for (int i = 0; i < preorder.length; i++) {
            // 根结点
            if (i == 0) {
                root = new TreeNode(preorder[i]);
                preNode = null;
                continue;
            }

            // 第二层结点
            if (preNode == null) {
                root.left = new TreeNode(preorder[i]);
                preNode = root;
                continue;
            }

            // 之后结点
            // check 新增结点在preNode 左侧是否符合中序遍历
            preNode.left.left = new TreeNode(preorder[i]);
            List<Integer> inOrderResult = new ArrayList<>();
            inOrderIterate(root, inOrderResult);
            boolean matchedInOrderInput = isMatchedInOrderInput(inorder, inOrderResult);
            if (matchedInOrderInput) {
                preNode = preNode.left;
                continue;
            }

            // check 新增结点在preNode 右侧是否符合中序遍历 // 该处需要多次check， 实现复杂。。。
        }

        return root;
    }

    private static boolean isMatchedInOrderInput(int[] inorder, List<Integer> inOrderResult) {
        String inOrderInputStr = "";
        for (int inOrderInputNum : inorder) {
            inOrderInputStr += inOrderInputNum + ",";
        }

        String inOrderResultStr = "";
        for (Integer inOrderResultNum : inOrderResult) {
            inOrderResultStr += inOrderResultNum + ",";
        }

        return inOrderInputStr.contains(inOrderResultStr);
    }

    public static void inOrderIterate(TreeNode head, List<Integer> result) {
        if (head == null) {
            return;
        }

        inOrderIterate(head.left, result);
        result.add(head.val);
        inOrderIterate(head.right, result);
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
