package com.zhyyu.learn.algorithm.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node node4 = new Node(4, null);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		
		Node head = node1;
		printLinkedList(head);
		
		Node newHead = reverseLinkedList(head);
		printLinkedList(newHead);
	}
	
	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	static Node reverseLinkedList(Node head) {
		Node pre = null;
		while (head != null) {
			Node next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		
		return pre;
	}
	
	static class Node {
		Integer value;
		Node next;
		public Node(Integer value, Node next) {
			this.value = value;
			this.next = next;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getNext() {
			return next;
		}
	}
	
}
