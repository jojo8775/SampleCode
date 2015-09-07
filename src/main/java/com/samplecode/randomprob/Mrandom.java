package com.samplecode.randomprob;

import com.samplecode.randomprob.RandomProb.Node;

public class Mrandom
{
	public static void main(String[] args)
	{
//		Node<String> node = new Node<String>("A");
//		Node<String> head = node;
//		node.next = new Node<String>("B");
//		node = node.next;
//		node.next = new Node<String>("C");
//		
//		node = head;
//		while(node != null)
//		{
//			System.out.println(node.val);
//			node = node.next;
//		}
//		
//		RandomProb prob = new RandomProb();
//		node = prob.reverseLinkedList(head);
//		
//		System.out.println("=============");
//		
//		while(node != null)
//		{
//			System.out.println(node.val);
//			node = node.next;
//		}
		
		RandomProb prob = new RandomProb();
		prob.findFactors(9);
	}
}
