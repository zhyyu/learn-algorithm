package com.zhyyu.learn.algorithm.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyu.yzy
 * @date 2021/1/28
 */
public class Jianzhi_35_复杂链表的复制 {

    public static void main(String[] args) {
        Node head = new Node(-1);

        Node copiedHead = new Solution().copyRandomList(head);
        System.out.println(copiedHead);
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            // build oldNodeIndexMap
            Map<Integer, Node> oldIndexNodeMap = new HashMap<>();
            int index = 0;
            Node oldCurrentNode = head;
            while (oldCurrentNode.next != null) {
                oldIndexNodeMap.put(index, oldCurrentNode);
                index++;
                oldCurrentNode = oldCurrentNode.next;
            }
            oldIndexNodeMap.put(index, oldCurrentNode);

            Map<Node, Integer> oldNodeIndexMap = new HashMap<>();
            for (Map.Entry<Integer, Node> indexNodeEntry : oldIndexNodeMap.entrySet()) {
                oldNodeIndexMap.put(indexNodeEntry.getValue(), indexNodeEntry.getKey());
            }

            // iterate old
            Map<Integer, Node> newIndexNodeMap = new HashMap<>();
            Node newHead = null;
            int newIndex = 0;
            while (head.next != null) {
                if (newHead == null) {
                    newHead = new Node(head.val);
                    newHead.next = head.next;
                    newHead.random = head.random;
                    head = head.next;
                    newIndexNodeMap.put(newIndex, newHead);
                    newIndex++;
                    continue;
                }

                Node copiedNode = new Node(head.val);
                copiedNode.next = head.next;
                copiedNode.random = head.random;
                head = head.next;
                newIndexNodeMap.put(newIndex, copiedNode);
                newIndex++;
            }

            if (newHead == null) {
                newHead = new Node(head.val);
                newHead.next = head.next;
                newHead.random = head.random;
                newIndexNodeMap.put(newIndex, newHead);
            } else {
                Node copiedNode = new Node(head.val);
                copiedNode.next = head.next;
                copiedNode.random = head.random;
                newIndexNodeMap.put(newIndex, copiedNode);
            }

            // iterate newIndexNodeMap
            for (Map.Entry<Integer, Node> newIndexNodeEntry : newIndexNodeMap.entrySet()) {
                if (newIndexNodeEntry.getValue().next != null) {
                    Integer nextIndex = oldNodeIndexMap.get(newIndexNodeEntry.getValue().next);
                    newIndexNodeEntry.getValue().next = newIndexNodeMap.get(nextIndex);
                }

                if (newIndexNodeEntry.getValue().random != null) {
                    Integer randomIndex = oldNodeIndexMap.get(newIndexNodeEntry.getValue().random);
                    newIndexNodeEntry.getValue().random = newIndexNodeMap.get(randomIndex);
                }
            }

            return newHead;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
