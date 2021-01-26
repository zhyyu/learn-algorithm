package com.zhyyu.learn.algorithm.jianzhi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyu.yzy
 * @date 2021/1/25
 */
public class Jianzhi_22_链表中倒数第k个节点 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new Solution().getKthFromEnd(node1, 2);
    }

    static class Solution {

        public ListNode getKthFromEnd(ListNode head, int k) {
            Map<Integer, ListNode> indexNodeMap = new HashMap<>();

            int index = 0;
            while (head.next != null) {
                indexNodeMap.put(++index, head);
                head = head.next;
            }
            indexNodeMap.put(index + 1, head);

            Integer maxIndex = indexNodeMap.keySet().stream().max(Comparator.comparing(key -> key)).get();
            int reverseIndex = maxIndex - k + 1;
            return indexNodeMap.get(reverseIndex);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
