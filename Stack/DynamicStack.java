package com.dsalearning;

public class DynamicStack extends stackImplementation{
	public DynamicStack(){
		super();
	}
	public DynamicStack(int size) {
		super(size);
	}
	
	@Override
	public boolean push(int item) {
		if(super.isFull()) {
			int[] tmp = new int[stack.length * 2];
			for(int i = 0;i<stack.length;i++) {
				tmp[i] = stack[i];
			}
			stack = tmp;
		}
		return super.push(item);
	}
}
