package com.samplecode.queue;

public class Mqueue
{
	public static void main(String[] args)
	{
		Queue<String> queue = new Queue<String>();
		
		queue.enQueue("z");
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
		queue.enQueue("A");
		queue.enQueue("B");
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.peek());
		
		queue.enQueue("c");
		System.out.println(queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.deQueue());
		System.out.println(queue.isEmpty());
	}
}
