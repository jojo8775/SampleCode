package com.samplecode.circularlinkedlist;


public class MCList
{
	public static void main(String[] args)
	{
		CircularLinkedList<Character> cList1 = createCircularLinkedList(charArr("123456789"));
		CircularLinkedList<Character> cList2 = createCircularLinkedList(charArr("123456789"));
		
		cList1.resetRunner();
		cList2.resetRunner();
		
		Character a = cList1.next();
		cList2.next();
		cList2.next();
		Character b = cList2.next();
		
		while(a != b)
		{
			a = cList1.next();
			cList2.next();
			b = cList2.next();
		}
		
		System.out.println(a);
		System.out.println(cList1.getLoopCount());
		System.out.println(cList2.getLoopCount());
	}
	
	private static Character[] charArr(String s)
	{
		Character[] c = new Character[s.length()];
		int i = 0;
		for(char ca : s.toCharArray())
		{
			c[i++] = ca;
		}
		
		return c;
	}
	
	private static <T> CircularLinkedList<T> createCircularLinkedList(T[] arr)
	{
		CircularLinkedList<T> list = new CircularLinkedList<T>();
		
		for(T singleItem : arr)
		{
			list.add(singleItem);
		}
		
		return list;
	}
}
