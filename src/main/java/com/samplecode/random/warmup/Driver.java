package com.samplecode.random.warmup;

import com.samplecode.random.warmup.WarmUp.TreeNode;

public class Driver
{
	public static void main(String[] args)
	{
//		int[] arr = {3,2,564,23,1,3,7,5,3};
		WarmUp warmUp = new WarmUp();
//		warmUp.heapSort(arr);
//		warmUp.mergeSort(arr);
//		warmUp.quickSort(arr);
//		warmUp.selectionSort(arr);
//		warmUp.insertionSort(arr);
//		print(arr);
		
//		warmUp.findNQueen(4);
		int[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode<Integer> root = warmUp.createBalancedBinaryTree(arr);
//		warmUp.preOrderTraversal_Rec(root);
//		System.out.println();
//		warmUp.preOrderTraversal(root);
		
		System.out.println(warmUp.findDepth(root));;
	}
	
	private static void print(int[] arr)
	{
		for(int i : arr)
		{
			System.out.println(i);
		}
	}
}
