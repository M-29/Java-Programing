package com.dsalearning;

public class QueueImplementationMain {
	public static void main(String[] args) {
		QueueImplementation q1 = new QueueImplementation();
		System.out.println(q1.push(1));
		System.out.println(q1.push(2));
		System.out.println(q1.push(3));
		System.out.println(q1.push(4));
		System.out.println(q1.push(5));
		System.out.println(q1.push(6));
		System.out.println(q1.push(7));
		System.out.println(q1.push(8));
		System.out.println(q1.push(9));
		System.out.println(q1.push(10));
		System.out.println(q1.remove());
		
		q1.display();
	}
}
