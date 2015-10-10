package com.samplecode.random.warmup;

import java.util.List;

import com.samplecode.random.warmup.WarmUp.LinkedList;
import com.samplecode.random.warmup.WarmUp.Node;
import com.samplecode.random.warmup.WarmUp.Point;
import com.samplecode.random.warmup.WarmUp.TreeNode;

import sun.font.CreatedFontTracker;

public class Driver
{
	public static void main(String[] args)
	{
		// int[] arr = {3,2,564,23,1,3,7,5,3};
		WarmUp warmUp = new WarmUp();
		// warmUp.heapSort(arr);
		// warmUp.mergeSort(arr);
		// warmUp.quickSort(arr);
		// warmUp.selectionSort(arr);
		// warmUp.insertionSort(arr);
		// print(arr);

		// warmUp.findNQueen(4);
		// int[] arr = {1,2,3,4,5,6,7,8,9};
		// TreeNode<Integer> root = warmUp.createBalancedBinaryTree(arr);

		// warmUp.preOrderTraversal_Rec(root);
		// System.out.println();
		// warmUp.preOrderTraversal(root);

		// warmUp.printNodesAtEachLevel(root);
		// System.out.println(warmUp.findNode(root, new TreeNode<Integer>(2),
		// new TreeNode<Integer>(4)));
		// System.out.println(warmUp.findDepth(root));
		// System.out.println(warmUp.findDepth_rec(root));

		// warmUp.printNodesAtEachLevel(root);
		// System.out.println(warmUp.getDiameter(root));

		// warmUp.printNodesAtEachLevel(root);
		// System.out.println("=========== after ============");
		// warmUp.printNodesAtEachLevel(warmUp.modifyTree(root));

		// int[] arr = {1,9,2,8,4,5,6,7,4};
		// print(warmUp.reArrangeArray(arr));

		// char[][] arr = new char[5][];
		//
		// for(int i=0; i<arr.length; i++)
		// {
		// arr[i] = new char[5];
		// for(int j=0; j<arr[i].length; j++)
		// {
		// arr[i][j] = ' ';
		// }
		// }
		//
		// warmUp.findShortestPath(arr, new Point(0, 0), new Point(4, 3));

		// System.out.println(warmUp.isEdit("ABC", "AB"));
		// System.out.println(warmUp.isEdit("ABC", "BC"));
		// System.out.println(warmUp.isEdit("ABC", "CAC"));
		// System.out.println(warmUp.isEdit("ABC", "CBC"));
		// System.out.println(warmUp.isEdit("ABC", "CACD"));
		// System.out.println(warmUp.isEdit("ABC", " ABC"));

		// Node<Integer> list = new Node<Integer>(1);
		// Node<Integer> head = list;
		// for (int i = 2; i < 8; i++)
		// {
		// list.next = new Node<Integer>(i);
		// list = list.next;
		// }
		//
		// Node<Integer> result = warmUp.editList(head, 1);
		//
		// while (result != null)
		// {
		// System.out.print(result.val + ", ");
		// result = result.next;
		// }

		// int[] arr = {-14,1,-3,-4,5,8,-7,9,3,4, -2};
		// int[] arr = {1,2,3,4,5,-1,-2,-3};
		// arr = warmUp.arrangeArr_1(arr);
		// print(arr);

		// int[] arr = {2,2,2};
		// TreeNode<Integer> root = warmUp.createBalancedBinaryTree(arr);
		// System.out.println(warmUp.isBinarySearchTree(root));

		// System.out.println(warmUp.findFactor(2));

		// int[] arr = {1,23,34,36,56,58,90,96};
		// System.out.println(warmUp.search(arr, 55));

		// warmUp.formatString();

		// LinkedList<Integer> temp = null;
		// LinkedList<Integer> list1 = new LinkedList<Integer>(1);
		// temp = list1;
		// temp.next = new LinkedList<Integer>(3);
		//
		// LinkedList<Integer> list2 = new LinkedList<Integer>(21);
		// temp = list2;
		// temp.next = new LinkedList<Integer>(30);
		// LinkedList<Integer> result = warmUp.mergeList(list1, list2);
		//
		// while (result != null)
		// {
		// System.out.print(result.value + ", ");
		// result = result.next;
		// }

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10};
		TreeNode<Integer> root = warmUp.createBalancedBinaryTree(arr);
		warmUp.printNodesAtEachLevel(root);
		warmUp.printNodesAtEachLevel(root);
		List<String> paths = warmUp.findPathsToLeaf(root);
		for (String p : paths)
		{
			System.out.println(p);
		}
	}

	private static void print(int[] arr)
	{
		for (int i : arr)
		{
			System.out.println(i);
		}
	}
}
