package com.samplecode.stack;

import com.samplecode.string.ArrayStack;

public class StackM
{
	public static void main(String[] args)
	{
//		Stack<String> stack = new Stack<String>();
//		stack.push("A");
//		stack.push("B");
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		
//		System.out.println(stack.isEmpty());
//		stack.push("C");
//		System.out.println(stack.isEmpty());
//		System.out.println(stack.pop());
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
		
		ArrayStack<String> arrayStack = new ArrayStack<String>(String.class, 4);

		arrayStack.pushStackOne("A");
		arrayStack.pushStackOne("B");
		arrayStack.pushStackTwo("B");
		arrayStack.pushStackTwo("B");
		arrayStack.pushStackThree("C");
		arrayStack.pushStackThree("C");
		
		System.out.println(arrayStack.peekStackTwo());
		System.out.println(arrayStack.popStackOne());
		System.out.println(arrayStack.popStackOne());
		System.out.println(arrayStack.popStackTwo());
		System.out.println(arrayStack.popStackTwo());
		System.out.println(arrayStack.popStackThree());
		System.out.println(arrayStack.popStackThree());
//		System.out.println(arrayStack.peekStackOne());
	}
}
