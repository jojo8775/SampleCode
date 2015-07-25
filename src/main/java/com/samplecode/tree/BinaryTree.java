package com.samplecode.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.samplecode.linkedlist.LinkedList;
import com.samplecode.linkedlist.LinkedListIterator;
import com.samplecode.queue.Queue;
import com.samplecode.stack.Stack;

public class BinaryTree
{
	private TreeNode root;

	public void createBalancedBinaryTree_ite(int[] arr)
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
	
	public TreeNode getRoot()
	{
		return root;
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

	public void printLevels()
	{
		List<LinkedList<TreeNode>> list = getLevels(root);

		for (LinkedList<TreeNode> l : list)
		{
			LinkedListIterator<TreeNode> iterator = l.getIterator();

			while (iterator.hasNext())
			{
				System.out.print(iterator.next().value + ", ");
			}

			System.out.println();
		}
	}

	private List<LinkedList<TreeNode>> getLevels(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<LinkedList<TreeNode>>();
		}

		TreeNode currentNode = root;

		List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(currentNode);

		result.add(list);

		while (!list.isEmpty())
		{
			LinkedList<TreeNode> currentList = new LinkedList<TreeNode>();

			LinkedListIterator<TreeNode> iterator = list.getIterator();
			while (iterator.hasNext())
			{
				TreeNode node = iterator.next();
				if (node.leftChild != null)
				{
					currentList.add(node.leftChild);
				}
				if (node.rightChild != null)
				{
					currentList.add(node.rightChild);
				}
			}

			result.add(currentList);
			list = currentList;
		}

		return result;
	}

	public void printAllPath()
	{
		getAllPath(root);
	}

	private void getAllPath(TreeNode root)
	{
		TreeNode currentNode = root;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(currentNode);

		while (!stack.isEmpty())
		{
			currentNode = stack.pop();
			if (currentNode.leftChild != null)
			{
				stack.push(currentNode.leftChild);
			}

			if (currentNode.rightChild != null)
			{
				stack.push(currentNode.rightChild);
			}

			if (currentNode.rightChild == null && currentNode.leftChild == null)
			{
				printPath(currentNode);
			}
		}
	}

	private void printPath(TreeNode node)
	{
		while (node != null)
		{
			System.out.print(node.value + ", ");
			node = node.parent;
		}

		System.out.println();
	}

	public void maxHeight()
	{
		System.out.println(maxHeight(root));
	}

	private int maxHeight(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}

		return 1 + Math.max(maxHeight(node.leftChild), maxHeight(node.rightChild));
	}

	public void minHeight()
	{
		System.out.println(minHeight(root));
	}

	private int minHeight(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}

		return 1 + Math.min(minHeight(node.leftChild), minHeight(node.rightChild));
	}

	public void createBalancedBinaryTree_rec(int[] arr)
	{
		root = createNode(arr, 0, arr.length - 1);
	}

	private TreeNode createNode(int[] arr, int beg, int end)
	{
		if (beg > end)
		{
			return null;
		}

		int middle = (end + beg) / 2;

		TreeNode node = new TreeNode();
		node.value = arr[middle];
		node.leftChild = createNode(arr, beg, middle - 1);
		
		if(node.leftChild != null)
		{
			node.leftChild.parent = node;
		}
		
		node.rightChild = createNode(arr, middle + 1, end);
		
		if(node.rightChild != null)
		{
			node.rightChild.parent = node;
		}

		return node;
	}

	public void findNode(int val)
	{
		TreeNode node = findNode(val, root);

		System.out.println(node != null);
	}

	private TreeNode findNode(int val, TreeNode node)
	{
		if (node == null)
		{
			return null;
		}

		System.out.print(node.value + ", ");

		if (node.value == val)
		{
			return node;
		}

		TreeNode tempNode = findNode(val, node.leftChild);
		if (tempNode != null)
		{
			return tempNode;
		}

		return findNode(val, node.rightChild);
	}

	public void printLeafNodes_ite()
	{
		List<TreeNode> leafNodes = getLeafNodes(root);

		for (TreeNode singleNode : leafNodes)
		{
			System.out.print(singleNode.value + ", ");
		}

		System.out.println();
	}

	private List<TreeNode> getLeafNodes(TreeNode root)
	{
		if (root == null)
		{
			return Collections.emptyList();
		}

		TreeNode currentNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(currentNode);

		List<TreeNode> leafNodes = new ArrayList<TreeNode>();

		while (!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			if (node.leftChild == null && node.rightChild == null)
			{
				leafNodes.add(node);
			}
			else
			{
				if (node.leftChild != null)
				{
					stack.push(node.leftChild);
				}
				if (node.rightChild != null)
				{
					stack.push(node.rightChild);
				}
			}

		}

		return leafNodes;
	}

	public void findCommonAncestor(int val1, int val2)
	{
		TreeNode node1 = findNode1(val1, root);
		TreeNode node2 = findNode1(val2, root);
		TreeNode commonNode = findCommonAncestor(node1, node2);
		
		if (commonNode == null)
		{
			System.out.println("null");
		}
		else
		{
			System.out.println(commonNode.value);
		}
	}

	private TreeNode findNode1(int val, TreeNode node)
	{
		if (node == null)
		{
			return null;
		}
//		System.out.print(node.value + ", ");
		if (node.value == val)
		{
			return node;
		}

		TreeNode tempNode = findNode1(val, node.leftChild);
		if (tempNode != null)
		{
			return tempNode;
		}

		tempNode = findNode1(val, node.rightChild);
		
		return tempNode;
	}

	private TreeNode findCommonAncestor(TreeNode node1, TreeNode node2)
	{

		if (node1 == null || node2 == null)
		{
			return null;
		}

		int depthDiff = getDepth(node1) - getDepth(node2);
		if (depthDiff > 0)
		{
			node1 = levelUpNode(node1, depthDiff);
		}
		else if (depthDiff < 0)
		{
			node2 = levelUpNode(node2, depthDiff * -1);
		}

		while (node1 != null)
		{
			if (node1 == node2)
			{
				return node1;
			}

			node1 = node1.parent;
			node2 = node2.parent;
		}

		return null;
	}

	private int getDepth(TreeNode node)
	{
		int depth = -1;
		while (node != null)
		{
			node = node.parent;
			depth++;
		}

		return depth;
	}

	private TreeNode levelUpNode(TreeNode node, int level)
	{
		while (level > 0)
		{
			node = node.parent;
			level--;
		}

		return node;
	}
	
	public void printLeafs_rec()
	{
		List<TreeNode> leafNodes = findLeafNodes(new ArrayList<TreeNode>(), root);

		for (TreeNode singleNode : leafNodes)
		{
			System.out.print(singleNode.value + ", ");
		}

		System.out.println();
	}
	
	private <T extends Collection<TreeNode>> T findLeafNodes(T collection, TreeNode node)
	{
		if(node == null)
		{
			return collection;
		}

		if(node.leftChild == null && node.rightChild == null)
		{
			collection.add(node);
		}

		findLeafNodes(collection, node.rightChild);
		
		return findLeafNodes(collection, node.leftChild);
	}
	
	public boolean isSubTree(TreeNode root1, TreeNode root2)
	{
		List<TreeNode> leafNodeSubTree = findLeafNodes(new ArrayList<TreeNode>(), root1);
		List<TreeNode> leafNodeParentTree = findLeafNodes(new ArrayList<TreeNode>(), root2);

		for(TreeNode singleParentTreeNode : leafNodeParentTree)
		{
			for(TreeNode singleSubTreeNode : leafNodeSubTree)
			{
				if(singleParentTreeNode.value == singleSubTreeNode.value)
				{
					if(isMatch(findRoot(singleParentTreeNode), findRoot(singleSubTreeNode)))
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	private TreeNode findRoot(TreeNode node)
	{

		while(node.parent != null)
		{
			node = node.parent;
		}

		return node;
	}
	
	
	public void isMatch()
	{
		System.out.println(isMatch(root, root));
	}
	
	private boolean isMatch(TreeNode node1, TreeNode node2)
	{
		if(node1 == null && node2 == null)
		{
			return true;
		}


		if(node1 == null)
		{
			return false;
		}

		if(node1.value != node2.value)
		{
			return false;
		}

		return (isMatch(node1.leftChild, node2.leftChild) && isMatch(node1.rightChild, node2.rightChild));
	}
}
