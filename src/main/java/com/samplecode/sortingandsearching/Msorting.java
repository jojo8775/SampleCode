package com.samplecode.sortingandsearching;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.samplecode.circularlinkedlist.CircularLinkedList;

public class Msorting
{
	public static void main(String[] args)
	{
		// Sorting sorting = new Sorting();
		// int[] arr = {4,3,23,4,1,3,2,6,8,22};
		// arr = sorting.mergeSort(arr);
		// arr = sorting.quickSort(arr);
		// arr = sorting.selectionSort(arr);
		// arr = sorting.insertionSort(arr);
		// print(arr);

		SortingProb prob = new SortingProb();

		// int[] a1 = {1,2,3,4,5,-1,-1,-1};
		// int[] a2 = {6,7,8};
		// prob.merge(a1, a2);

		// String[] strArr = new String[4];
		// strArr[0] = "dog";
		// strArr[1] = "dog";
		// strArr[2] = "cat";
		// strArr[3] = "god";
		// prob.sortAnagram(strArr);
		// print(strArr);

		// int[] arr = {2,3,4,5,1};
		// System.out.println(prob.findElement(arr, 5));

		// CircularLinkedList<Integer> circularLinkedList = new
		// CircularLinkedList<Integer>();
		// circularLinkedList.add(createList(300));
		// List<List<Integer>> result = circularLinkedList.getRoatationState();
		// int searchIndex = 0;
		//
		// for (List<Integer> itemList : result)
		// {
		// int[] arr = new int[itemList.size()];
		//
		// for (int i = 0; i < itemList.size(); i++)
		// {
		// arr[i] = itemList.get(i);
		// }
		// // print(arr);
		// // System.out.println(prob.findElement(arr, 5));
		// // System.out.println(prob.findIndex(arr, 5));
		// // System.out.println(prob.search(arr, 5));
		// searchIndex = prob.search_mod(arr, 5);
		// if(searchIndex == -1)
		// {
		// break;
		// }
		// System.out.println(searchIndex);
		// }
		//
		// if(searchIndex == -1)
		// {
		// System.out.println("failed");
		// }
		// else
		// {
		// System.out.println("success");
		// }

		System.out.println(prob.search(
				toArray(String.class, Arrays.asList("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")),
				"ball"));
	}

	private static <T> T[] toArray(Class clazz, List<T> list)
	{
		T[] arr = (T[]) Array.newInstance(clazz, list.size());

		for (int i = 0; i < list.size(); i++)
		{
			arr[i] = list.get(i);
		}

		return arr;
	}

	private static List<Integer> createList(int num)
	{
		List<Integer> list = new ArrayList<Integer>(num);

		for (int i = 1; i <= num; i++)
		{
			list.add(i);
		}

		return list;
	}

	private static <T> void print(List<List<T>> resultList)
	{
		for (List<T> itemList : resultList)
		{
			for (T item : itemList)
			{
				System.out.print(item + ", ");
			}

			System.out.println();
		}
	}

	private static <T> void print(T[] arr)
	{
		for (T i : arr)
		{
			System.out.print(i + ", ");
		}

		System.out.println();
	}

	private static void print(int[] arr)
	{
		for (int i : arr)
		{
			System.out.print(i + ", ");
		}

		System.out.println();
	}
}
