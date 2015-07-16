package com.samplecode.linkedlist;

public class Mlist
{
	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		
		LinkedListIterator<String> iterator = list.getIterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
