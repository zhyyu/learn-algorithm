package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongyu.yzy
 * @date 2021/1/20
 */
public class Jianzhi_06_从尾到头打印链表 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);

        listNode1.next = listNode3;
        listNode3.next = listNode2;

        int[] ints = reversePrint(listNode1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] reversePrint(ListNode head) {
        ListNode currentNode = head;

        ListNode preNode = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }

        List<Integer> reverseVals = new ArrayList<>();

        while (preNode != null) {
            reverseVals.add(preNode.val);
            preNode = preNode.next;
        }

        int[] reverseInts = reverseVals.stream().mapToInt(i -> i).toArray();
        return reverseInts;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
