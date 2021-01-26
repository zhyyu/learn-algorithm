package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_18_删除链表的节点 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode currentNode = head;

            // 头结点是删除结点
            if (head.val == val) {
                return head.next;
            }

            ListNode preNode = null;
            while (currentNode.next != null) {
                if (currentNode.val == val) {
                    preNode.next = currentNode.next;
                }

                preNode = currentNode;
                currentNode = currentNode.next;
            }

            // 最后一个结点是删除结点
            if (currentNode.val == val) {
                preNode.next = null;
            }

            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
