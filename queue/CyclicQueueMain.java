package com.dsalearning;

public class CyclicQueueMain {
	public static void main(String[] args) {
		CyclicQueue c = new CyclicQueue();
		System.out.println(c.push(1));
		System.out.println(c.push(2));
		System.out.println(c.push(3));
		System.out.println(c.push(4));
		System.out.println(c.push(5));
		System.out.println(c.push(6));
		System.out.println(c.push(7));
		System.out.println(c.push(8));
		System.out.println(c.push(9));
		System.out.println(c.push(10));
		System.out.println(c.remove());
		System.out.println(c.push(11));
		
		c.display();
		System.out.println("Display all the element");
	}
}
