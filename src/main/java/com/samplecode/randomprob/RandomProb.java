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
	
	public void findFactors(int num)
	{
		for(int i=2; i<num; i++)
		{
			if(num % i == 0)
			{
				System.out.print(i + ", ");
			}
		}
	}
	
	public int reverseNumber(int num)
	{
		boolean isNegative = (num < 0);
		
		if(isNegative)
		{
			num = num * -1;
		}
		
		int result = 0;
		while(num > 0)
		{
			result = result << 1;
			result = result | (num & 1);
			num = num >> 1;
		}
		
		return isNegative ? result * -1 : result;
	}
}
