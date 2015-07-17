package com.samplecode.tree;

public class Mtree
{
	public static void main(String[] args)
	{
		BinaryTree bTree = new BinaryTree();

		int[] arr = {1,2,3,4,5,6,7,8,9,10};
//		bTree.createBalancedBinaryTree_ite(arr);

//		bTree.inOrder_rec();
//		System.out.println();
//		bTree.inOrder_ite();
		
//		bTree.preOrder_rec();
//		System.out.println();
//		bTree.preOrder_ite();
		
//		bTree.postOrder_rec();
//		System.out.println();
//		bTree.postOrder_ite();
		
//		bTree.printLevels();
//		bTree.printAllPath();
		
//		bTree.maxHeight();
//		bTree.minHeight();

		bTree.createBalancedBinaryTree_rec(arr);
		bTree.printLevels();
		
//		for(int i = 0; i< 12; i++)
//		{
//			bTree.findNode(i);
//		}
	}
}
