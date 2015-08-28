package com.samplecode.randomprob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomProb
{
	public static class Node<T>
	{
		public T val;
		public Node<T> next;

		public Node(T val)
		{
			this.val = val;
		}
	}

	public <T> Node<T> reverseLinkedList(Node<T> node)
	{
		Node<T> prevNode = node;
		Node<T> currentNode = node.next;
		Node<T> tempNode = null;
		prevNode.next = null;

		while (currentNode != null)
		{
			tempNode = currentNode;
			currentNode = currentNode.next;
			tempNode.next = prevNode;
			prevNode = tempNode;
		}

		return prevNode;
	}
}
