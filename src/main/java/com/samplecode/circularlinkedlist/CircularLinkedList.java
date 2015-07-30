package com.samplecode.circularlinkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularLinkedList<T>
{
	private Node<T> head;
	private Node<T> runnerNode;
	private int loopCount;

	public CircularLinkedList()
	{
		head = new Node<T>();
		runnerNode = head;
		head.nextNode = runnerNode;
		runnerNode.nextNode = head;
	}

	public void add(T value)
	{
		Node<T> node = new Node<T>();
		node.value = value;
		node.nextNode = runnerNode.nextNode;
		runnerNode.nextNode = node;
		runnerNode = node;
	}

	public void add(List<T> list)
	{
		for (T item : list)
		{
			add(item);
		}
	}

	public void resetRunner()
	{
		runnerNode = head.nextNode;
		loopCount = 0;
	}

	public void clear()
	{
		runnerNode = head;
		head.nextNode = runnerNode;
		runnerNode.nextNode = head;
		loopCount = 0;
	}

	public T next()
	{
		if (runnerNode == head && runnerNode.nextNode == head)
		{
			return null;
		}

		T value = runnerNode.value;
		if (runnerNode.nextNode == head)
		{
			runnerNode = runnerNode.nextNode.nextNode;
			loopCount++;
		}
		else
		{
			runnerNode = runnerNode.nextNode;
		}

		return value;
	}

	public int getLoopCount()
	{
		return loopCount;
	}

	public List<List<T>> getRoatationState()
	{
		List<List<T>> result = new ArrayList<List<T>>();

		if (head == runnerNode)
		{
			return result;
		}

		resetRunner();
		Node<T> markerNode = runnerNode;

		while (markerNode != head)
		{
			List<T> loopList = new ArrayList<T>();
	
			do
			{
				loopList.add(next());
			} while (markerNode != runnerNode);

			markerNode = markerNode.nextNode;
			runnerNode = markerNode;
			result.add(loopList);
		}

		return result;
	}

	public static class Node<T>
	{
		public Node<T> nextNode;
		public T value;
	}
}
