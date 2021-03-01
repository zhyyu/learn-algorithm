package com.zhyyu.learn.algorithm.other;

import java.util.HashMap;
import java.util.Map;

public class Tencent_1_LRU {

    public static void main(String[] args) {
        LURCache lurCache = new LURCache(2);
        lurCache.set(1, 1);
        lurCache.set(2, 2);
        lurCache.set(3, 3);

        System.out.println(lurCache.get(1));
        System.out.println(lurCache.get(2));
    }

    static class LURCache {

        Map<Integer, DoubleLinkedNode> dataMap = new HashMap<>();
        DoubleLinkedNode head;
        DoubleLinkedNode tail;
        int capacity;

        public LURCache(int capacity) {
            head = new DoubleLinkedNode();
            tail = new DoubleLinkedNode();
            head.nextDoubleLinkedNode = tail;
            tail.preDoubleLinkedNode = head;
            this.capacity = capacity;
        }

        static class DoubleLinkedNode {
            DoubleLinkedNode preDoubleLinkedNode;
            DoubleLinkedNode nextDoubleLinkedNode;

            int key;
            int val;

            public DoubleLinkedNode() {
            }

            public DoubleLinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int get(int key) {
            DoubleLinkedNode doubleLinkedNode = dataMap.get(key);
            if (doubleLinkedNode == null) {
                return -1;
            }

            removeNode(doubleLinkedNode);
            moveNode2Head(doubleLinkedNode);
            return doubleLinkedNode.val;
        }

        void set(int key, int value) {
            DoubleLinkedNode doubleLinkedNode = dataMap.get(key);
            if (doubleLinkedNode != null) {
                removeNode(doubleLinkedNode);
                moveNode2Head(doubleLinkedNode);
                return;
            }

            if (dataMap.size() >= capacity) {
                DoubleLinkedNode lruNode = tail.preDoubleLinkedNode;
                dataMap.remove(lruNode.key);
                removeNode(lruNode);
            }

            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            moveNode2Head(newNode);
            dataMap.put(key, newNode);
        }

        private void moveNode2Head(DoubleLinkedNode doubleLinkedNode) {
            DoubleLinkedNode headNextNode = head.nextDoubleLinkedNode;
            head.nextDoubleLinkedNode = doubleLinkedNode;
            headNextNode.preDoubleLinkedNode = doubleLinkedNode;
            doubleLinkedNode.preDoubleLinkedNode = head;
            doubleLinkedNode.nextDoubleLinkedNode = headNextNode;
        }

        private void removeNode(DoubleLinkedNode doubleLinkedNode) {
            DoubleLinkedNode preDLinkedNode = doubleLinkedNode.preDoubleLinkedNode;
            DoubleLinkedNode nextDLinkedNode = doubleLinkedNode.nextDoubleLinkedNode;

            preDLinkedNode.nextDoubleLinkedNode = nextDLinkedNode;
            nextDLinkedNode.preDoubleLinkedNode = preDLinkedNode;
        }

    }


}
