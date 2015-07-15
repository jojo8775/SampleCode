package com.samplecode.tree;

import com.samplecode.queue.Queue;
import com.samplecode.stack.Stack;

public class BinaryTree
{
	private TreeNode root;

	public void createBalancedBinaryTree(int[] arr)
	{
		if (arr.length == 0)
		{
			return;
		}

		root = new TreeNode();
		root.value = arr[0];

		TreeNode currentNode = root;
		Queue<TreeNode> queue = new Queue<TreeNode>();
		queue.enQueue(currentNode);

		int index = 0;

		while (index < arr.length)
		{
			currentNode = queue.deQueue();
			if ((++index) < arr.length)
			{
				currentNode.leftChild = createNode(currentNode, arr[index]);
				queue.enQueue(currentNode.leftChild);
			}

			if ((++index) < arr.length)
			{
				currentNode.rightChild = createNode(currentNode, arr[index]);
				queue.enQueue(currentNode.rightChild);
			}
		}
	}

	private TreeNode createNode(TreeNode parentNode, int val)
	{
		TreeNode node = new TreeNode();
		node.value = val;
		node.parent = parentNode;

		return node;
	}

	public void inOrder_rec()
	{
		inOrder_rec(root);
	}

	private void inOrder_rec(TreeNode node)
	{
		if (node == null)
		{
			return;
		}

		inOrder_rec(node.leftChild);
		System.out.print(node.value + ", ");
		inOrder_rec(node.rightChild);
	}

	public void inOrder_ite()
	{
		inorder_itc(root);
	}

	public void inorder_itc(TreeNode root)
	{
		if (root == null)
		{
			return;
		}

		TreeNode currentNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (true)
		{
			while (currentNode != null)
			{
				stack.push(currentNode);
				currentNode = currentNode.leftChild;
			}

			currentNode = stack.pop();

			if (currentNode == null)
			{
				break;
			}

			System.out.print(currentNode.value + ", ");

			currentNode = currentNode.rightChild;
		}
	}

	public void preOrder_rec()
	{
		preOrder_rec(root);
	}

	private void preOrder_rec(TreeNode node)
	{
		if (node == null)
		{
			return;
		}

		System.out.print(node.value + ", ");
		preOrder_rec(node.leftChild);
		preOrder_rec(node.rightChild);
	}

	public void preOrder_ite()
	{
		if (root == null)
		{
			return;
		}

		TreeNode currentNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (true)
		{
			while (currentNode != null)
			{
				System.out.print(currentNode.value + ", ");
				stack.push(currentNode);
				currentNode = currentNode.leftChild;
			}

			currentNode = stack.pop();
			if (currentNode == null)
			{
				break;
			}

			currentNode = currentNode.rightChild;
		}
	}

	public void postOrder_rec()
	{
		postOrder_rec(root);
	}

	private void postOrder_rec(TreeNode node)
	{
		if (node == null)
		{
			return;
		}

		postOrder_rec(node.leftChild);
		postOrder_rec(node.rightChild);
		System.out.print(node.value + ", ");
	}

	public void postOrder_ite()
	{
		if (root == null)
		{
			return;
		}

		TreeNode currentNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		do
		{
			while (currentNode != null)
			{
				if (currentNode.rightChild != null)
				{
					stack.push(currentNode.rightChild);
				}
				stack.push(currentNode);
				currentNode = currentNode.leftChild;
			}

			currentNode = stack.pop();
			if (currentNode == null)
			{
				break;
			}

			if (currentNode.rightChild != null && currentNode.rightChild == stack.peek())
			{
				stack.pop();
				stack.push(currentNode);
				currentNode = currentNode.rightChild;
			}
			else
			{
				System.out.print(currentNode.value + ", ");
				currentNode = null;
			}

		} while (!stack.isEmpty());
	}

	private static class TreeNode
	{
		public TreeNode leftChild;
		public TreeNode rightChild;
		public TreeNode parent;
		public int value;
	}
}
