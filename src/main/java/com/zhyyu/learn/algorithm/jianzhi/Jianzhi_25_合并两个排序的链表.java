package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_25_合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode listNode = new Solution().mergeTwoLists(null, null);
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode l1Head = l1;
            ListNode l2Head = l2;

            List<ListNode> nodeList = new ArrayList<>();
            ListNode nextNode;
            while (findNext(l1Head, l2Head) != null) {
                nextNode = findNext(l1Head, l2Head);
                nodeList.add(nextNode);
                if (nextNode == l1Head) {
                    l1Head = l1Head.next;
                } else {
                    l2Head = l2Head.next;
                }
            }

            // 构造新链表
            for (int i = 0; i < nodeList.size(); i++) {
                if (i == nodeList.size() - 1) {
                    nodeList.get(i).next = null;
                    break;
                }
                nodeList.get(i).next = nodeList.get(i + 1);
            }

            if (nodeList.size() > 0) {
                return nodeList.get(0);
            } else {
                return null;
            }

        }

        private ListNode findNext(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }

            if (l1 == null && l2 != null) {
                return l2;
            }

            if (l1 != null && l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                return l1;
            } else {
                return l2;
            }
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
