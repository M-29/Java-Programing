package com.dsalearning;

public class QueueImplementation {
	public static final int DEFAULT_SIZE = 10;
	private int[] queue;
	int end =0;
	public QueueImplementation() {
		this(DEFAULT_SIZE);
	}
	public QueueImplementation(int size) {
		this.queue = new int[size];
	}
	public boolean isFull() {
		return end == queue.length;
	}
	public boolean isEmpty() {
		return end == 0;
	}
	public boolean push(int item) {
		if(isFull()) {
			System.out.println("Queue is full");
			return false;
		}
		queue[end++] = item;
		return true;
	}
	public int remove() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int removed = queue[0];
		for(int i = 1; i < end; i++) {
			queue[i-1] = queue[i];
		}
		end--;
		return removed;
	}
	public void display() {
		for(int i = 0; i < queue.length; i++) {
			System.out.println(queue[i]);
		}
	}
}
