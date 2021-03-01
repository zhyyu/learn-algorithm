package com.zhyyu.learn.algorithm.other;

import java.util.HashMap;
import java.util.Map;

public class Xiaomi_1_LRU {

    public static void main(String[] args) {

    }

    static class LRUCache {
        Map<Integer, DoubleLinkedNode> data = new HashMap<>();
        DoubleLinkedNode head;
        DoubleLinkedNode tail;
        int capacity;


        static class DoubleLinkedNode {
            DoubleLinkedNode pre;
            DoubleLinkedNode next;

            Integer key;
            Integer val;

            public DoubleLinkedNode(Integer key, Integer val) {
                this.key = key;
                this.val = val;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new DoubleLinkedNode(null, null);
            tail = new DoubleLinkedNode(null, null);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DoubleLinkedNode doubleLinkedNode = data.get(key);
            if (doubleLinkedNode == null) {
                return -1;
            }

            removeNode(doubleLinkedNode);
            addNode2Head(doubleLinkedNode);
            return doubleLinkedNode.val;
        }

        public void put(int key, int value) {
            DoubleLinkedNode doubleLinkedNode = data.get(key);
            if (doubleLinkedNode == null) {
                if (data.size() >= capacity) {
                    DoubleLinkedNode lruNode = this.tail.pre;
                    data.remove(lruNode.key);
                    removeNode(lruNode);
                }

                DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
                data.put(key, newNode);

                addNode2Head(newNode);
                return;
            }

            doubleLinkedNode.val = value;
            removeNode(doubleLinkedNode);
            addNode2Head(doubleLinkedNode);
        }

        private void addNode2Head(DoubleLinkedNode doubleLinkedNode) {
            DoubleLinkedNode headNext = head.next;
            doubleLinkedNode.pre = head;
            doubleLinkedNode.next = headNext;

            head.next = doubleLinkedNode;
            headNext.pre = doubleLinkedNode;
        }

        private void removeNode(DoubleLinkedNode doubleLinkedNode) {
            DoubleLinkedNode preNode = doubleLinkedNode.pre;
            DoubleLinkedNode nextNode = doubleLinkedNode.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }
    }

}
