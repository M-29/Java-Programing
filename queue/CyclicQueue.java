package com.dsalearning;

public class CyclicQueue {
	int[] cyclicQueue;
	int e = 0;
	int f = 0;
	int size = 0;
	public static final int DEFAULT_SIZE = 10;
	public CyclicQueue() {
		this(DEFAULT_SIZE);
	}
	public CyclicQueue(int size) {
		this.cyclicQueue = new int[size]; 
	}
	public boolean isFull() {
		return size == cyclicQueue.length;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean push(int item) {
		if(isFull()) {
			System.out.println("Queue is full");
			return false;
		}
		cyclicQueue[e++] = item;
		e = e % cyclicQueue.length;
		size++;
		return true;
	}
	public int remove() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int removed = cyclicQueue[f++];
		f = f % cyclicQueue.length;
		size--;
		return removed;
	}
	public void display() {
		int i = f;
		do {
			System.out.println("Items : "+cyclicQueue[i]);
			i++;
			i %= cyclicQueue.length;
		}
		while(i != e);
		System.out.println("Items ends");
	}
}
