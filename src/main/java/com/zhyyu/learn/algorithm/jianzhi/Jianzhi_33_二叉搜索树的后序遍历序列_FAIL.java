package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Stack;

/**
 * @author zhongyu.yzy
 * @date 2021/1/27
 */
public class Jianzhi_33_二叉搜索树的后序遍历序列_FAIL {

    public static void main(String[] args) {
//        System.out.println(new Solution().verifyPostorder(new int[] {1, 3, 2, 6, 5}));
//        System.out.println(new Solution().verifyPostorder(new int[] {1, 6, 3, 2, 5}));
//        System.out.println(new Solution().verifyPostorder(new int[] {5, 4, 3, 2, 1}));

        // fail
        System.out.println(new Solution().verifyPostorder(new int[] {4, 8, 6, 12, 16, 14, 10}));

    }

    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length == 0) {
                return true;
            }

            if (postorder.length == 1) {
                return true;
            }

            if (postorder.length == 2) {
                return true;
            }

            Stack<Integer> postOrderStack = new Stack<>();
            for (int i = 0; i < postorder.length; i++) {
                postOrderStack.add(postorder[postorder.length - 1 - i]);
            }

            // todo 如此重建二叉树错误
            TreeNode preTreeNode = new TreeNode(postorder[0]);;
            while (postOrderStack.size() >= 3) {
                Integer first = postOrderStack.pop();
                Integer second = postOrderStack.pop();
                Integer third = postOrderStack.pop();

                // min max mid
                if (second > third && third > first) {
                    boolean greaterThanTree = isGreaterThanTree(third, preTreeNode);
                    if (!greaterThanTree) {
                        return false;
                    }

                    TreeNode maxTreeNode = new TreeNode(second);
                    TreeNode midTreeNode = new TreeNode(third);
                    midTreeNode.left = preTreeNode;
                    midTreeNode.right = maxTreeNode;

                    preTreeNode = midTreeNode;
                    postOrderStack.push(midTreeNode.val);
                }

                // min mid max
                if (first < second && second < third) {
                    boolean greaterThanTree = isGreaterThanTree(second, preTreeNode);
                    if (!greaterThanTree) {
                        return false;
                    }

                    TreeNode midTreeNode = new TreeNode(second);
                    TreeNode maxTreeNode = new TreeNode(third);
                    maxTreeNode.left = midTreeNode;
                    midTreeNode.left = preTreeNode;

                    preTreeNode = maxTreeNode;
                    postOrderStack.push(maxTreeNode.val);
                }

                // mid min max
                if (first > second && third > first) {
                    boolean greaterThanTree = isGreaterThanTree(third, preTreeNode);
                    if (!greaterThanTree) {
                        return false;
                    }

                    boolean lessThanTree = isLessThanTree(second, preTreeNode);
                    if (!lessThanTree) {
                        return false;
                    }

                    TreeNode minTreeNode = new TreeNode(second);
                    TreeNode maxTreeNode = new TreeNode(third);
                    maxTreeNode.left = minTreeNode;
                    minTreeNode.right = preTreeNode;

                    preTreeNode = maxTreeNode;
                    postOrderStack.push(maxTreeNode.val);
                }

                // mid max min
                if (first > third && second > first) {
                    boolean greaterThanTree = isGreaterThanTree(second, preTreeNode);
                    if (!greaterThanTree) {
                        return false;
                    }

                    boolean lessThanTree = isLessThanTree(third, preTreeNode);
                    if (!lessThanTree) {
                        return false;
                    }

                    TreeNode maxTreeNode = new TreeNode(second);
                    TreeNode minTreeNode = new TreeNode(third);
                    minTreeNode.right = maxTreeNode;
                    maxTreeNode.left = preTreeNode;

                    preTreeNode = minTreeNode;
                    postOrderStack.push(minTreeNode.val);
                }

                // max min mid
                if (first > third && third > second) {
                    return false;
                }

                // max mid min
                if (first > second && second > third) {
                    boolean lessThanTree = isLessThanTree(second, preTreeNode);
                    if (!lessThanTree) {
                        return false;
                    }

                    TreeNode minTreeNode = new TreeNode(third);
                    TreeNode midTreeNode = new TreeNode(second);
                    minTreeNode.right = midTreeNode;
                    midTreeNode.right = preTreeNode;

                    preTreeNode = minTreeNode;
                    postOrderStack.push(minTreeNode.val);
                }
            }

            return true;
        }

        private boolean isGreaterThanTree(Integer val, TreeNode treeNode) {
            if (treeNode == null) {
                return true;
            }

            if (val < treeNode.val) {
                return false;
            }

            if (treeNode.left == null && treeNode.right == null) {
                return true;
            }

            if (treeNode.left != null && treeNode.right == null) {
                return isGreaterThanTree(val, treeNode.left);
            }

            if (treeNode.left == null && treeNode.right != null) {
                return isGreaterThanTree(val, treeNode.right);
            }

            return isGreaterThanTree(val, treeNode.left) && isGreaterThanTree(val, treeNode.right);
        }

        private boolean isLessThanTree(Integer val, TreeNode treeNode) {
            if (treeNode == null) {
                return true;
            }

            if (val > treeNode.val) {
                return false;
            }

            if (treeNode.left == null && treeNode.right == null) {
                return true;
            }

            if (treeNode.left != null && treeNode.right == null) {
                return isLessThanTree(val, treeNode.left);
            }

            if (treeNode.left == null && treeNode.right != null) {
                return isLessThanTree(val, treeNode.right);
            }

            return isLessThanTree(val, treeNode.left) && isLessThanTree(val, treeNode.right);
        }


        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
            }
        }
    }

}
