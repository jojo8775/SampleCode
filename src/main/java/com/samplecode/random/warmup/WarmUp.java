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

	public <T> void printNodesAtEachLevel(TreeNode<T> node)
	{
		if (node == null)
		{
			return;
		}

		List<TreeNode<T>> list1 = new ArrayList<TreeNode<T>>();
		list1.add(node);

		while (!list1.isEmpty())
		{
			List<TreeNode<T>> list2 = new ArrayList<TreeNode<T>>();
			for (TreeNode<T> singleNode : list1)
			{
				System.out.print(singleNode.value + ", ");
				if (singleNode.leftChild != null)
				{
					list2.add(singleNode.leftChild);
				}
				if (singleNode.rightChild != null)
				{
					list2.add(singleNode.rightChild);
				}
			}

			list1 = list2;
			System.out.println();
		}
	}

	public <T> boolean findNode(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2)
	{
		if (root == null || node1 == null || node2 == null)
		{
			return false;
		}

		return findNodes(root, node1, node2, 0) == 2;
	}

	private <T> int findNodes(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2, int count)
	{
		if (root == null)
		{
			return 0;
		}

		int nodesFound = count;

		if (root.value.equals(node1.value) || root.value.equals(node2.value))
		{
			nodesFound++;
		}

		if (nodesFound == 2)
		{
			return nodesFound;
		}

		nodesFound = findNodes(root.leftChild, node1, node2, nodesFound);

		return findNodes(root.rightChild, node1, node2, nodesFound);
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

	public <T> int findDepth_rec(TreeNode<T> node)
	{
		if (node == null)
		{
			return 0;
		}

		return 1 + Math.max(findDepth_rec(node.leftChild), findDepth_rec(node.rightChild));
	}

	public <T> int getDiameter(TreeNode<T> root)
	{
		if (root == null)
		{
			return 0;
		}
		return getDepth(root.leftChild) + getDepth(root.rightChild) + 1;
	}

	private <T> int getDepth(TreeNode<T> node)
	{
		if (node == null)
		{
			return 0;
		}
		return 1 + Math.max(getDepth(node.leftChild), getDepth(node.rightChild));
	}

	public int[] reArrangeArray(int[] arr)
	{
		if (arr.length == 0 || arr.length <= 2)
		{
			return arr;
		}

		int[] result = new int[arr.length];

		int evenIndex = 1;
		int oddIndex = 0;
		int emptySlotFromEnd = arr.length - 1;

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] % 2 == 0)
			{
				if (evenIndex < arr.length)
				{
					result[evenIndex] = arr[i];
					evenIndex += 2;
				}
				else
				{
					result[emptySlotFromEnd--] = arr[i];
				}
			}
			else
			{
				if (oddIndex < arr.length)
				{
					result[oddIndex] = arr[i];
					oddIndex += 2;
				}
				else
				{
					result[emptySlotFromEnd--] = arr[i];
				}
			}
		}

		return result;
	}

	public TreeNode<Integer> modifyTree(TreeNode<Integer> node)
	{
		if (node == null)
		{
			return node;
		}

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(node);

		while (!stack.isEmpty())
		{
			TreeNode<Integer> tempNode = stack.pop();
			Integer value = 0;

			if (tempNode.leftChild != null)
			{
				stack.push(tempNode.leftChild);
				value = tempNode.leftChild.value;
			}

			if (tempNode.rightChild != null)
			{
				stack.push(tempNode.rightChild);
				value = value + tempNode.rightChild.value;
			}

			tempNode.value = value;
		}

		return node;
	}

	public void findShortestPath(char[][] arr, Point start, Point end)
	{
		Queue<Point> queue = new Queue<Point>();
		queue.enQueue(start);
		arr[start.x][start.y] = '1';

		int tempVal = 0;
		boolean endReachable = false;

		while (!queue.isEmpty())
		{
			Point tempPoint = queue.deQueue();
			if (tempPoint.x == end.x && tempPoint.y == end.y)
			{
				endReachable = true;
				break;
			}

			tempVal = arr[tempPoint.x][tempPoint.y];

			// move down
			if (tempPoint.x + 1 < arr.length)
			{
				if (arr[tempPoint.x + 1][tempPoint.y] != '*' && arr[tempPoint.x + 1][tempPoint.y] == ' ')
				{
					queue.enQueue(new Point(tempPoint.x + 1, tempPoint.y));
					arr[tempPoint.x + 1][tempPoint.y] = (char) (tempVal + 1);
				}
			}

			// move up
			if (tempPoint.x - 1 >= 0)
			{
				if (arr[tempPoint.x - 1][tempPoint.y] != '*' && arr[tempPoint.x - 1][tempPoint.y] == ' ')
				{
					queue.enQueue(new Point(tempPoint.x - 1, tempPoint.y));
					arr[tempPoint.x - 1][tempPoint.y] = (char) (tempVal + 1);
				}
			}

			// move left
			if (tempPoint.y - 1 >= 0)
			{
				if (arr[tempPoint.x][tempPoint.y - 1] != '*' && arr[tempPoint.x][tempPoint.y - 1] == ' ')
				{
					queue.enQueue(new Point(tempPoint.x, tempPoint.y - 1));
					arr[tempPoint.x][tempPoint.y - 1] = (char) (tempVal + 1);
				}
			}

			// move right
			if (tempPoint.y + 1 < arr[0].length)
			{
				if (arr[tempPoint.x][tempPoint.y + 1] != '*' && arr[tempPoint.x][tempPoint.y + 1] == ' ')
				{
					queue.enQueue(new Point(tempPoint.x, tempPoint.y + 1));
					arr[tempPoint.x][tempPoint.y + 1] = (char) (tempVal + 1);
				}
			}
		}

		print(arr);

		if (!endReachable)
		{
			System.out.println("Not reachabe");
		}
	}

	private void print(char[][] arr)
	{
		for (char[] c1 : arr)
		{
			for (char c : c1)
			{
				System.out.print(c + ", ");
			}

			System.out.println();
		}
	}

	public boolean isEdit(String str1, String str2)
	{
		if (str1 == null || str2 == null || str1.equals(str2) || Math.abs(str1.length() - str2.length()) > 1
				|| (str1.isEmpty() && str2.isEmpty()))
		{
			return false;
		}

		int misMatchCount = 0;
		int count1 = 0;
		int count2 = 0;

		String longerString = ((str1.length() - str2.length()) >= 0) ? str1 : str2;
		String shorterString = (str1.equals(longerString)) ? str2 : str1;

		// match first element
		if (longerString.charAt(0) == shorterString.charAt(0))
		{
			while (count1 < longerString.length())
			{
				if (count2 >= shorterString.length() || longerString.charAt(count1) != shorterString.charAt(count2))
				{
					misMatchCount++;
				}

				if (misMatchCount > 1)
				{
					return false;
				}

				count1++;
				count2++;
			}
		}
		else
		{
			count2 = shorterString.length() - 1;
			count1 = longerString.length() - 1;
			while (count1 >= 0)
			{
				if (count2 < 0 || longerString.charAt(count1) != shorterString.charAt(count2))
				{
					misMatchCount++;
				}

				if (misMatchCount > 1)
				{
					return false;
				}

				count1--;
				count2--;
			}
		}

		return true;
	}

	public <T> Node<T> editList(Node<T> list, int num)
	{
		if (num < 1 || list == null)
		{
			throw new IllegalArgumentException("Invalid parameters");
		}

		Node<T> currentNode = list;
		Node<T> prevNode = null;

		while (currentNode != null && num > 0)
		{
			num--;
			prevNode = currentNode;
			currentNode = currentNode.next;
		}

		Node<T> node1 = prevNode;
		Node<T> node2 = currentNode;
		Node<T> tempNode = null;

		while (currentNode != null)
		{
			// reached last node
			if (currentNode.next == null && !node1.equals(prevNode))
			{
				node1.next = prevNode;
				node2.next = currentNode;
				break;
			}

			tempNode = currentNode;
			currentNode = currentNode.next;
			tempNode.next = prevNode;
			prevNode = currentNode;
		}

		return list;
	}

	public static class Node<T>
	{
		public T val;
		public Node<T> next;

		public Node(T val)
		{
			this.val = val;
		}
	}

	public static class Point
	{
		public int x;
		public int y;

		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public static class TreeNode<T>
	{
		public T value;
		public TreeNode<T> leftChild;
		public TreeNode<T> rightChild;

		public TreeNode()
		{

		}

		public TreeNode(T value)
		{
			this.value = value;
		}
	}
}
