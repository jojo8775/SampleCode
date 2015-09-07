package com.samplecode.random.warmup;

import java.util.ArrayList;
import java.util.List;

import com.samplecode.queue.Queue;
import com.samplecode.stack.Stack;

public class WarmUp
{
	public int[] heapSort(int[] arr)
	{
		for (int i = arr.length / 2; i > 0; i--)
		{
			heapify(arr, i, arr.length);
		}

		printMaxHeap(arr);

		return arr;
	}

	private void heapify(int[] arr, int index, int arrLength)
	{
		int largestIndex = index;
		if ((index * 2) <= arrLength && arr[(index * 2) - 1] > arr[index - 1])
		{
			largestIndex = (index * 2);
		}
		if (((index * 2) + 1) <= arrLength && arr[(index * 2)] > arr[largestIndex - 1])
		{
			largestIndex = (index * 2) + 1;
		}

		if (largestIndex != index)
		{
			int temp = arr[index - 1];
			arr[index - 1] = arr[largestIndex - 1];
			arr[largestIndex - 1] = temp;
			heapify(arr, largestIndex, arrLength);
		}
	}

	private void printMaxHeap(int[] arr)
	{
		int length = arr.length;
		while (length > 0)
		{
			System.out.println(arr[0]);
			arr[0] = arr[--length];
			heapify(arr, 1, length);
		}
	}

	public int[] mergeSort(int[] arr)
	{
		if (arr.length == 0 || arr.length == 1)
		{
			return arr;
		}

		mergeSort(0, arr.length - 1, arr);
		return arr;
	}

	private void mergeSort(int beg, int end, int[] arr)
	{
		if (beg < end)
		{
			int middle = (beg + end) / 2;
			mergeSort(beg, middle, arr);
			mergeSort(middle + 1, end, arr);
			merge(beg, middle, end, arr);
		}
	}

	private void merge(int beg, int middle, int end, int[] arr)
	{
		int leftIndex = 0;
		int[] leftArr = new int[middle - beg + 1];

		for (int i = beg; i <= middle; i++)
		{
			leftArr[leftIndex++] = arr[i];
		}

		int rightIndex = 0;
		int[] rightArr = new int[end - middle];

		for (int i = middle + 1; i <= end; i++)
		{
			rightArr[rightIndex++] = arr[i];
		}

		leftIndex = 0;
		rightIndex = 0;
		int index = beg;

		while (leftIndex < leftArr.length)
		{
			if (rightIndex < rightArr.length && leftArr[leftIndex] > rightArr[rightIndex])
			{
				arr[index++] = rightArr[rightIndex++];
			}
			else
			{
				arr[index++] = leftArr[leftIndex++];
			}
		}

		while (rightIndex < rightArr.length)
		{
			arr[index++] = rightArr[rightIndex++];
		}
	}

	public int[] quickSort(int[] arr)
	{
		if (arr.length == 0 || arr.length == 1)
		{
			return arr;
		}

		quickSort(0, arr.length - 1, arr);
		return arr;
	}

	private void quickSort(int beg, int end, int[] arr)
	{
		if (beg < end)
		{
			int pivot = findPivot(beg, end, arr);
			quickSort(beg, pivot - 1, arr);
			quickSort(pivot + 1, end, arr);
		}
	}

	private int findPivot(int beg, int end, int[] arr)
	{
		int pivot = random(beg, end);
		swap(end, pivot, arr);
		pivot = end;

		int index = beg - 1;

		for (int i = beg; i <= end; i++)
		{
			if (arr[i] < arr[pivot])
			{
				if (i != ++index)
				{
					swap(index, i, arr);
				}
			}
		}

		swap(++index, pivot, arr);

		return index;
	}

	private int random(int ceiling, int floor)
	{
		return (int) (Math.random() * (ceiling - floor)) + floor;
	}

	private void swap(int index1, int index2, int[] arr)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public int[] selectionSort(int[] arr)
	{
		if (arr.length == 0 || arr.length == 1)
		{
			return arr;
		}

		int minIndex = 0;

		for (int i = 0; i < arr.length - 1; i++)
		{
			minIndex = i;

			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[minIndex] > arr[j])
				{
					minIndex = j;
				}
			}

			if (i != minIndex)
			{
				swap(minIndex, i, arr);
			}
		}

		return arr;
	}

	public int[] insertionSort(int[] arr)
	{
		if (arr.length == 0 || arr.length == 1)
		{
			return arr;
		}

		for (int i = 1; i < arr.length; i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (arr[j - 1] > arr[j])
				{
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
				else
				{
					break;
				}
			}
		}

		return arr;
	}

	public void findNQueen(int num)
	{
		if (num < 4)
		{
			System.out.println("-Queen solution is not possible.");
			return;
		}

		findNQueen(num, new int[num], 0);
	}

	private void findNQueen(int queenCount, int[] queenPos, int col)
	{
		if (queenCount == col)
		{
			printSolution(queenPos);
			return;
		}

		for (int i = 0; i < queenPos.length; i++)
		{
			queenPos[col] = i;
			if (isSafeToPlace(queenPos, col))
			{
				findNQueen(queenCount, queenPos, col + 1);
				queenPos[col] = 0;
			}
		}
	}

	private boolean isSafeToPlace(int[] queenPos, int col)
	{
		// checking queen in same row
		for (int i = col - 1; i >= 0; i--)
		{
			if (queenPos[col] == queenPos[i])
			{
				return false;
			}
		}

		// checking diagonals
		for (int i = col - 1; i >= 0; i--)
		{
			if ((col - i) == Math.abs(queenPos[col] - queenPos[i]))
			{
				return false;
			}
		}

		return true;
	}

	private void printSolution(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
	}

	public TreeNode<Integer> createBalancedBinaryTree(int[] arr)
	{
		if (arr.length == 0)
		{
			return null;
		}

		Queue<TreeNode<Integer>> queue = new Queue<TreeNode<Integer>>();
		TreeNode<Integer> rootNode = new TreeNode<Integer>();
		rootNode.value = arr[0];
		queue.enQueue(rootNode);

		int index = 0;

		while (!queue.isEmpty())
		{
			TreeNode<Integer> node = queue.deQueue();

			if (++index < arr.length)
			{
				node.leftChild = new TreeNode<Integer>();
				node.leftChild.value = arr[index];
				queue.enQueue(node.leftChild);
			}

			if (++index < arr.length)
			{
				node.rightChild = new TreeNode<Integer>();
				node.rightChild.value = arr[index];
				queue.enQueue(node.rightChild);
			}
		}

		return rootNode;
	}

	public void preOrderTraversal_Rec(TreeNode<Integer> node)
	{
		if (node == null)
		{
			return;
		}

		System.out.print(node.value + ", ");
		preOrderTraversal_Rec(node.leftChild);
		preOrderTraversal_Rec(node.rightChild);
	}

	public void preOrderTraversal(TreeNode<Integer> node)
	{
		if (node == null)
		{
			return;
		}

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(node);

		while (!stack.isEmpty())
		{
			TreeNode<Integer> tempNode = stack.pop();
			System.out.print(tempNode.value + ", ");

			if (tempNode.rightChild != null)
			{
				stack.push(tempNode.rightChild);
			}

			if (tempNode.leftChild != null)
			{
				stack.push(tempNode.leftChild);
			}
		}
	}

	public <T> int findDepth(TreeNode<T> node)
	{
		if (node == null)
		{
			return 0;
		}

		List<TreeNode<T>> list1 = new ArrayList<TreeNode<T>>();
		list1.add(node);

		int depth = -1;

		while (!list1.isEmpty())
		{
			List<TreeNode<T>> list2 = new ArrayList<TreeNode<T>>();
			for (TreeNode<T> singleNode : list1)
			{
				if (singleNode.leftChild != null)
				{
					list2.add(singleNode.leftChild);
				}
				if (singleNode.rightChild != null)
				{
					list2.add(singleNode.rightChild);
				}
			}

			depth++;
			list1 = list2;
		}

		return depth;
	}

	public static class TreeNode<T>
	{
		public T value;
		public TreeNode<T> leftChild;
		public TreeNode<T> rightChild;
	}
}
