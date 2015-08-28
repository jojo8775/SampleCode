package com.samplecode.queue.priority;

import java.util.Arrays;

public class MHeap
{
	public static void main(String[] args)
	{
		Heap heap = new Heap();
		heap.createHeap(Arrays.asList(12L, 34L, 23L, 2L, 87L, 3L, 24L));

		int count = 10;

		while (count > 0)
		{
			System.out.println(heap.getMax());
			count--;
		}
	}
}
