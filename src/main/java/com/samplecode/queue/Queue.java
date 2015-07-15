package com.samplecode.queue;

public class Queue<T>
{
	private Node<T> head;
	private Node<T> tail;

	public void enQueue(T val)
	{
		if (head == null)
		{
			tail = new Node<T>();
			tail.value = val;

			head = tail;
		}
		else
		{
			Node<T> node = new Node<T>();
			node.value = val;
			tail.previous = node;
			tail = node;
		}
	}

	public T deQueue()
	{
		if (head == null)
		{
			return null;
		}

		Node<T> node = head;
		head = head.previous;

		return node.value;
	}

	public T peek()
	{
		if (head == null)
		{
			return null;
		}

		return head.value;
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public static class Node<T>
	{
		public Node<T> previous;
		public T value;
	}
}