package com.samplecode.stack;

public class StackM
{
	public static void main(String[] args)
	{
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.isEmpty());
		stack.push("C");
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
	}
}
