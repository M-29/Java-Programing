package com.linkedlistLearning;

public class LinkedListMain {
	public static void main(String[] args) {
//		LinkedList l = new LinkedList();
//		l.insertFirst(5);
//		l.insertFirst(4);
//		l.insertFirst(3);
//		l.insertFirst(2);
//		l.insertFirst(1);
//		l.insertLast(6);
//		l.insertAtPos(7, 3);
//		l.displayList();
//		l.deleteFirst();
//		l.displayList();
//		l.deleteLast();
//		l.displayList();
//		l.deleteAtPos(2);
//		l.displayList();
		
		DoublyLinkedList l = new DoublyLinkedList();
		l.insertFirst(5);
		l.insertFirst(4);
		l.insertFirst(3);
		l.insertFirst(2);
		l.insertFirst(1);
		l.display();
		l.insertLast(6);
		l.display();
		l.insertAfter(4, 8);
		l.display();
	}
}
