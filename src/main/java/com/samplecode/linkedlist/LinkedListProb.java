package com.samplecode.linkedlist;

import com.samplecode.linkedlist.LinkedList.Node;

public class LinkedListProb
{
	public <T> void removeDuplicate(LinkedList<T> list)
	{
		printList(list);
		list = removeDuplicateHelper(list);
		printList(list);
	}

	public <T> LinkedList<T> removeDuplicateHelper(LinkedList<T> list)
	{
		Node<T> refNode = list.getFirstNode();
		Node<T> currentNode = null;
		Node<T> prevNode = null;

		while (refNode != null)
		{
			prevNode = refNode;
			currentNode = prevNode.nextNode;
			while (currentNode != null)
			{
				if (!refNode.value.equals(currentNode.value))
				{
					prevNode.nextNode = currentNode;
					prevNode = currentNode;
				}

				currentNode = currentNode.nextNode;
			}

			prevNode.nextNode = currentNode;
			refNode = refNode.nextNode;
		}

		return list;
	}

	public <T> void removeDuplicate_sortedList(LinkedList<T> list)
	{
		printList(list);
		list = removeDuplicateHelper_sortedList(list);
		printList(list);
	}

	public <T> LinkedList<T> removeDuplicateHelper_sortedList(LinkedList<T> list)
	{
		Node<T> refNode = list.getFirstNode();
		Node<T> currentNode = null;

		while (refNode != null)
		{
			currentNode = refNode.nextNode;

			if (currentNode == null)
			{
				break;
			}

			if (refNode.value.equals(currentNode.value))
			{
				refNode.nextNode = refNode.nextNode.nextNode;
			}

			refNode = refNode.nextNode;
		}

		return list;
	}

	public <T> void findNthElement_ite(LinkedList<T> list, int num)
	{
		T result = findNthElement(list, num);
		printList(list);
		System.out.println(result);
	}

	private <T> T findNthElement(LinkedList<T> list, int num)
	{
		Node<T> refNode = list.getFirstNode();
		
		if (num < 1 || refNode == null)
		{
			return null;
		}

		Node<T> currentNode = refNode;
		while (num > 0)
		{
			if (currentNode == null)
			{
				return null;
			}

			currentNode = currentNode.nextNode;
			num --;
		}

		while (currentNode != null)
		{
			currentNode = currentNode.nextNode;
			refNode = refNode.nextNode;
		}

		return refNode.value;
	}
	
	public <T> void findNthElement_rec(LinkedList<T> list, int num)
	{
		if(list == null || num < 1)
		{
			System.out.println("null");
		}

		Node<T> node = list.getFirstNode();

		System.out.println(findNthNumHelper(node, node, num));
	}


	private <T> T findNthNumHelper(Node<T> refNode, Node<T> currentNode, int num)
	{
		if(currentNode == null)
		{
			if(num > 0)
			{
				return null;
			}

			return refNode.value;
		}

		if(num < 1)
		{
			refNode = refNode.nextNode;
		}
		else
		{
			num --;
		}

		return findNthNumHelper(refNode, currentNode.nextNode, num);
	}
	
	public void findSum(LinkedList<Integer> list1, LinkedList<Integer> list2)
	{
		LinkedList<Integer> list3 = getSumHelper(list1, list2);
		printList(list3);
	}

	private LinkedList<Integer> getSumHelper(LinkedList<Integer> list1, LinkedList<Integer> list2)
	{
		LinkedList<Integer> result = new LinkedList<Integer>();

		Node<Integer> node1 = list1.getFirstNode();
		Node<Integer> node2 = list2.getFirstNode();

		int sum = 0;
		int carry = 0;

		while(true)
		{
			if(node1 == null && node2 == null && carry == 0)
			{
				break;
			}

			sum = carry;

			if(node1 != null)
			{
				sum += node1.value;
				node1 = node1.nextNode;
			}

			if(node2 != null)
			{
				sum += node2.value;
				node2 = node2.nextNode;
			}

			carry = sum/10;
			result.add(sum%10);
		}

		return result;
	}
	
	
	public <T> void printList(LinkedList<T> list)
	{
		LinkedListIterator<T> iterator = list.getIterator();
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + ", ");
		}
		System.out.println();
	}
}
