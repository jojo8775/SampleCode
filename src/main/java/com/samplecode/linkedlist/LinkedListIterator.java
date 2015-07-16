package com.samplecode.linkedlist;

import java.util.Iterator;

import com.samplecode.linkedlist.LinkedList.Node;

public class LinkedListIterator<T> implements Iterator<T>
{
	private Node<T> head;
	private Node<T> current;
	
	public LinkedListIterator(Node<T> node)
	{
		this.head = node;
		current = head;
	}
	@Override
	public boolean hasNext()
	{
		return current != null;
	}

	@Override
	public T next()
	{
		Node<T> node = current;
		current = current.nextNode;
		return node.value;
	}
}
