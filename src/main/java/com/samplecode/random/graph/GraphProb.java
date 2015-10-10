package com.samplecode.random.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.samplecode.stack.Stack;

public class GraphProb
{
	private Map<Node, List<Edge>> adjacencyList = new HashMap<Node, List<Edge>>();

	public void addNode(Node a, Node b)
	{
		Edge e = new Edge();
		e.destinationNode = b;

		if (adjacencyList.get(a) == null)
		{
			adjacencyList.put(a, new ArrayList<Edge>());
		}

		adjacencyList.get(a).add(e);
	}

	public void printAllPath(Node a, Node b)
	{
		if (a == null || b == null)
		{
			System.out.println("Nothing to print and input is null");
		}

		Stack<Node> stack = new Stack<Node>();
		List<Node> path = new ArrayList<Node>();
		Map<Node, Integer> pathIndex = new HashMap<GraphProb.Node, Integer>();

		stack.push(a);
		pathIndex.put(a, 0);

		Node tempNode = null;

		while (!stack.isEmpty())
		{
			tempNode = stack.pop();

			if (path.size() < (pathIndex.get(tempNode)))
			{
				path.add(tempNode);
			}
			else
			{
				path.add(pathIndex.get(tempNode), tempNode);
			}

			if (tempNode.value == b.value)
			{
				print(path, pathIndex.get(tempNode));
				continue;
			}

			if (adjacencyList.get(tempNode) != null)
			{
				for (Edge e : adjacencyList.get(tempNode))
				{
					stack.push(e.destinationNode);
					pathIndex.put(e.destinationNode, pathIndex.get(tempNode) + 1);
				}
			}
		}
	}

	private void print(List<Node> path, int count)
	{
		for (int i = 0; i <= count; i++)
		{
			System.out.print("->" + path.get(i).value);
		}
		System.out.println();
	}

	public static class Node
	{
		public char value;

		public Node(char value)
		{
			this.value = value;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (value != other.value)
				return false;
			return true;
		}
	}

	public static class Edge
	{
		public Node destinationNode;
		public int value;

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((destinationNode == null) ? 0 : destinationNode.hashCode());
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (destinationNode == null)
			{
				if (other.destinationNode != null)
					return false;
			}
			else if (!destinationNode.equals(other.destinationNode))
				return false;
			if (value != other.value)
				return false;
			return true;
		}
	}
}
