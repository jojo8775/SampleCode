package com.samplecode.linkedlist;

public class LinkedList<T>
{

	private Node<T> head = new Node<T>();
	private Node<T> current = head;

	public void add(T val)
	{
		current.nextNode = new Node<T>();
		current.nextNode.value = val;
		current = current.nextNode;
	}
	
//	public void remove(T val)
//	{
//		Node<T> temp = head;
//		
//		while(temp != null)
//		{
//			if(temp.value == val)
//			{
//				if(temp.nextNode == null)
//				{
//					temp = temp.nextNode;
//				}
//				else
//				{
//					temp = temp.nextNode.nextNode;
//				}
//
//				break;
//			}
//		}
//	}

	public void clear()
	{
		head = new Node<T>();
		current = head;
	}
	
	private static class Node<T>
	{
		public Node<T> nextNode;
		public T value;
	}	
}
