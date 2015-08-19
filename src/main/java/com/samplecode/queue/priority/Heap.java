package com.samplecode.queue.priority;

import java.util.ArrayList;
import java.util.List;

public class Heap
{
	private List<Long> list = new ArrayList<Long>();

	public void createHeap(List<Long> list)
	{
		this.list.addAll(list);
		heapify();
	}

	private void heapify()
	{
		int index = list.size() / 2;
		while (index > 0)
		{
			heapifyHelper(list, index);
			index--;
		}
	}

	private void heapifyHelper(List<Long> list, int index)
	{
		int maxIndex = index - 1;
		int twiceIndex = 2 * index - 1;

		if (((2 * index) <= list.size()) && list.get(maxIndex) < list.get(twiceIndex))
		{
			maxIndex = twiceIndex;
		}

		if (((2 * index + 1) <= list.size()) && list.get(maxIndex) < list.get(twiceIndex + 1))
		{
			maxIndex = twiceIndex + 1;
		}

		if (maxIndex != (index - 1))
		{
			Long temp = list.get(index - 1);
			list.set(index - 1, list.get(maxIndex));
			list.set(maxIndex, temp);

			heapifyHelper(list, maxIndex + 1);
		}
	}

	public Long getMax()
	{
		if (list.isEmpty())
		{
			return -1L;
		}

		Long val = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		heapifyHelper(list, 1);

		return val;
	}
}