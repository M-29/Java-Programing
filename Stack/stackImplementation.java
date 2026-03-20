package com.dsalearning;

import java.util.Arrays;

class stackImplementation{
	public boolean isFull;
	public boolean isEmpty;
	private static final int DEFAULT_SIZE = 5;
	public int[] stack;
	int ptr = -1;
	
	
	public stackImplementation(){
		this(DEFAULT_SIZE);
	}
	public stackImplementation(int size) {
		this.stack = new int[size];
	}
	public boolean push(int item) {
		if(isFull()) {
			System.out.println("Stack is full");
			return false;
		}
		ptr++;
		stack[ptr] = item;
		return true;
	}
	public boolean isFull() {
		return ptr == stack.length-1;
	}
	public boolean isEmpty() {
		return ptr == -1;
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty nothing can be popped");
			return -1;
		}
		return stack[ptr--];
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty nothing can be fetched");
			return -1;
		}
		return stack[ptr];
	}
	
}
