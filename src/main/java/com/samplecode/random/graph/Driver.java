package com.samplecode.random.graph;

import com.samplecode.random.graph.GraphProb.Node;

public class Driver
{
	public static void main(String args[])
	{
		GraphProb prob = new GraphProb();
		prob.addNode(new Node('1'), new Node('3'));
		prob.addNode(new Node('1'), new Node('2'));
		prob.addNode(new Node('3'), new Node('4'));
		prob.addNode(new Node('3'), new Node('6'));
		prob.addNode(new Node('4'), new Node('6'));
		prob.addNode(new Node('2'), new Node('5'));
		prob.addNode(new Node('5'), new Node('6'));
		
		prob.printAllPath(new Node('1'), new Node('6'));
	}
}
