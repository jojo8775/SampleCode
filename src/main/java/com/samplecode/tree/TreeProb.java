package com.samplecode.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TreeProb
{
	public boolean isSubTree(TreeNode root1, TreeNode root2)
	{
		if(root1 == null || root2 == null)
		{
			System.out.println("Null root");
			return false;
		}
		
		boolean status = isSubTreeHelper(root1, root2);
		System.out.println(status);
		
		return status;
	}
	
	private boolean isSubTreeHelper(TreeNode root1, TreeNode root2)
	{
		List<TreeNode> leafNodeSubTree = findLeafNodes(new ArrayList<TreeNode>(), root1);
		List<TreeNode> leafNodeParentTree = findLeafNodes(new ArrayList<TreeNode>(), root2);

		for(TreeNode singleParentTreeNode : leafNodeParentTree)
		{
			for(TreeNode singleSubTreeNode : leafNodeSubTree)
			{
				if(singleParentTreeNode.value == singleSubTreeNode.value)
				{
					if(isMatch(levelUp(singleParentTreeNode, findHeight(singleSubTreeNode)), root2))
					{
						return true;
					}
				}
			}
		}

		return false;
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

	private int findHeight(TreeNode node)
	{
		int height = 0;
		while(node.parent != null)
		{
			height++;
			node = node.parent;
		}

		return height;
	}

	private TreeNode levelUp(TreeNode node, int level)
	{
		while(level > 0 || node != null)
		{
			node = node.parent;
			level --;
		}

		return node;
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
