package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class Jianzhi_52_两个链表的第一个公共节点 {

    public static void main(String[] args) {

    }

    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            List<ListNode> aTraceList = new ArrayList<>();
            while (headA.next != null) {
                aTraceList.add(headA);
                headA = headA.next;
            }
            aTraceList.add(headA);

            while (headB.next != null) {
                if (aTraceList.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            if (aTraceList.contains(headB)) {
                return headB;
            }

            return null;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
