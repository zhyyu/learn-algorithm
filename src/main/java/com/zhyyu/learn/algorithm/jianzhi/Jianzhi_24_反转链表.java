package com.zhyyu.learn.algorithm.jianzhi;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_24_反转链表 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode tail = head;

            ListNode pre = null;
            ListNode currentNode = head;
            while (currentNode.next != null) {
                ListNode tmp = currentNode.next;
                currentNode.next = pre;
                pre = currentNode;
                currentNode = tmp;
            }

            currentNode.next = pre;
            tail.next = null;

            return currentNode;
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
