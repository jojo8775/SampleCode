package com.samplecode.stack;

public class Stack<T>
{
	private Node<T> head;

	public void push(T val)
	{
		Node<T> node = new Node<T>();
		node.value = val;
		node.previous = head;
		head = node;
	}

	public T pop()
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

	private static class Node<T>
	{
		public Node<T> previous;
		public T value;
	}
}