package com.samplecode.linkedlist;

public class Mlist
{
	public static void main(String[] args)
	{
		LinkedListProb linkedListProb = new LinkedListProb();

//		LinkedList<Character> list = createLinkedList("FOLLOWUP");
//		linkedListProb.removeDuplicate(list);
		
//		LinkedList<Character> list = createLinkedList(charArr("abbbcccdddaaa"));
//		linkedListProb.removeDuplicate(list);
		
//		int[] arr = {1,2,3,4,5,6,7,8,9,10};		
//		LinkedList<Integer> list = createLinkedList(intArr(arr));
//		linkedListProb.findNthElement_ite(list, 3);
//		linkedListProb.findNthElement_rec(list, 3);
		
		
		int[] arr1 = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
//		int[] arr2 = {5,9,2};
		linkedListProb.findSum(createLinkedList(intArr(arr1)), createLinkedList(intArr(arr1)));
		
	}

	private static Integer[] intArr(int[] arr)
	{
		Integer[] ii = new Integer[arr.length];
		int i = 0;
		for(Integer a : arr)
		{
			ii[i++] = a;
		}
		
		return ii;
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
	
	private static <T> LinkedList<T> createLinkedList(T[] arr)
	{
		LinkedList<T> list = new LinkedList<T>();
		
		for(T singleItem : arr)
		{
			list.add(singleItem);
		}
		
		return list;
	}
}
