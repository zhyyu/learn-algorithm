package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyu.yzy
 * @date 2021/1/28
 */
public class Jianzhi_36_二叉搜索树与双向链表 {

    public static void main(String[] args) {

    }

    static class Solution {

        private List<Node> midOrderNodeList = new ArrayList<>();

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }

            midOrder(root);
            Node head = midOrderNodeList.get(0);
            for (int i = 0; i < midOrderNodeList.size(); i++) {
                int preNodeIndex = i == 0 ? midOrderNodeList.size() - 1 : (i - 1);
                midOrderNodeList.get(i).left = midOrderNodeList.get(preNodeIndex);

                int afterNodeIndex = i == midOrderNodeList.size() - 1 ? 0 : i + 1;
                midOrderNodeList.get(i).right = midOrderNodeList.get(afterNodeIndex);
            }

            return head;
        }

        private void midOrder(Node node) {
            if (node.left != null) {
                midOrder(node.left);
            }
            midOrderNodeList.add(node);
            if (node.right != null) {
                midOrder(node.right);
            }
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

}
