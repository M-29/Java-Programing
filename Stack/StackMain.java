package com.dsalearning;

import java.util.Arrays;

public class StackMain {
	public static void main(String[] args) {
		stackImplementation si = new DynamicStack();
		System.out.println(si.push(1));
		System.out.println(si.push(2));
		System.out.println(si.push(3));
		System.out.println(si.push(4));
		System.out.println(si.push(5));
		System.out.println(si.push(6));
		System.out.println(si.push(7));
		System.out.println("Length : "+si.stack.length);
		
		System.out.println(si.pop());
		System.out.println(si.pop());
		System.out.println(si.pop());
		
		System.out.println(si.peek());
		System.out.println(Arrays.toString(si.stack));
		System.out.println(si.ptr);
	}
}
