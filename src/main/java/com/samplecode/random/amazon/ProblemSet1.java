package com.samplecode.random.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.samplecode.stack.Stack;

public class ProblemSet1
{
	// solution 1
	public void printRepeatedEntries(int[] arr)
	{
		if (arr.length < 2)
		{
			return;
		}

		int count = 1;

		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i - 1] == arr[i])
			{
				count++;
			}
			else if (count != 1)
			{
				System.out.println(arr[i - 1] + " is repeated " + count + " times.");
				count = 1;
			}
		}

		if (count != 1)
		{
			System.out.println(arr[arr.length - 1] + " is repeated " + count + " times.");
		}
	}

	public String sortString(char[] charArr)
	{
		int lowerIndex = -1;
		for (int i = 0; i < charArr.length; i++)
		{
			if (charArr[i] >= 'a' && charArr[i] <= 'z')
			{
				lowerIndex++;
				if (lowerIndex != i)
				{
					swap(lowerIndex, i, charArr);
				}
			}
		}

		int spaceIndex = lowerIndex;
		for (int i = lowerIndex + 1; i < charArr.length; i++)
		{
			if (charArr[i] == ' ')
			{
				spaceIndex++;
				if (spaceIndex != i)
				{
					swap(spaceIndex, i, charArr);
				}
			}
		}

		return String.copyValueOf(charArr);
	}

	private void swap(int index1, int index2, char[] charArr)
	{
		char temp = charArr[index1];
		charArr[index1] = charArr[index2];
		charArr[index2] = temp;
	}

	// Given a grid find the number of islands. The adjacent islands are
	public int findNumberOfIslands(int[][] grid)
	{
		int numberOfIsland = 0;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				if (grid[i][j] == 1)
				{
					markAdjacentLadVisited(grid, i, j, grid.length, grid[i].length);
					numberOfIsland++;
				}
			}
		}

		return numberOfIsland;
	}

	private void markAdjacentLadVisited(int[][] grid, int x, int y, int maxX, int maxY)
	{
		if (x == maxX || y == maxY || x < 0 || y < 0)
		{
			return;
		}

		if (grid[x][y] != 1)
		{
			return;
		}

		grid[x][y] = -1;

		// check top
		markAdjacentLadVisited(grid, x - 1, y, maxX, maxY);

		// check bottom
		markAdjacentLadVisited(grid, x + 1, y, maxX, maxY);

		// check left
		markAdjacentLadVisited(grid, x, y + 1, maxX, maxY);

		// check right
		markAdjacentLadVisited(grid, x, y - 1, maxX, maxY);
	}

	public String formatString(String str)
	{
		if (str == null)
		{
			throw new IllegalArgumentException("Input cannot be null.");
		}

		if (str.isEmpty())
		{
			return str;
		}

		char[] charArr = str.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		char prevChar = charArr[0];
		int sameCharCount = 1;

		for (int i = 1; i < charArr.length; i++)
		{
			if (prevChar == charArr[i])
			{
				sameCharCount++;
			}
			else
			{
				stringBuilder.append(prevChar);

				if (sameCharCount > 1)
				{
					stringBuilder.append(sameCharCount);
				}

				sameCharCount = 1;
				prevChar = charArr[i];
			}
		}

		stringBuilder.append(prevChar);

		if (sameCharCount > 1)
		{
			stringBuilder.append(sameCharCount);
		}

		return stringBuilder.toString();
	}

	public static class ProductionOrder
	{
		private int id;
		private int parentId;

		public ProductionOrder(int parentId, int id)
		{
			this.id = id;
			this.parentId = parentId;
		}

		public int getId()
		{
			return id;
		}

		public int getParentId()
		{
			return parentId;
		}
		
		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + parentId;
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
			ProductionOrder other = (ProductionOrder) obj;
			if (id != other.id)
				return false;
			if (parentId != other.parentId)
				return false;
			return true;
		}
	}

	public Collection<ProductionOrder> getLeafProductionOrders(List<ProductionOrder> productionOrders)
	{
		rejectIfInvalid(productionOrders);
		
		if(productionOrders.size() == 1 || productionOrders.isEmpty())
		{
			return productionOrders;
		}

		Map<Integer, Stack<ProductionOrder>> orderAndImmidiateChildMap = new HashMap<Integer, Stack<ProductionOrder>>();

		for (ProductionOrder singleOrder : productionOrders)
		{
			if (singleOrder.getParentId() > 0)
			{
				if (orderAndImmidiateChildMap.get(singleOrder.getParentId()) == null)
				{
					orderAndImmidiateChildMap.put(singleOrder.getParentId(), new Stack<ProductionOrder>());
				}

				orderAndImmidiateChildMap.get(singleOrder.getParentId()).push(singleOrder);
			}
		}

		Set<ProductionOrder> leafOrders = new HashSet<ProductionOrder>();

		for (ProductionOrder singleOrder : productionOrders)
		{
			if (orderAndImmidiateChildMap.get(singleOrder.getId()) == null)
			{
				leafOrders.add(singleOrder);
			}
			else
			{
				Stack<ProductionOrder> childOrders = orderAndImmidiateChildMap.get(singleOrder.getId());

				while (!childOrders.isEmpty())
				{
					ProductionOrder childOrder = childOrders.pop();
					if (orderAndImmidiateChildMap.get(childOrder.getId()) == null)
					{
						leafOrders.add(childOrder);
					}
					else
					{
						Stack<ProductionOrder> tempStack = orderAndImmidiateChildMap.get(childOrder.getId());
						while (!tempStack.isEmpty())
						{
							childOrders.push(tempStack.pop());
						}
					}
				}
			}
		}

		return leafOrders;
	}

	private void rejectIfInvalid(List<ProductionOrder> orders)
	{
		if (orders == null)
		{
			throw new IllegalArgumentException("Given input is null");
		}

		Map<Integer, ProductionOrder> orderHashTable = new HashMap<Integer, ProductionOrder>(orders.size());

		for (ProductionOrder singleOrder : orders)
		{
			if (singleOrder == null)
			{
				throw new IllegalArgumentException("Given input has null entry");
			}

			orderHashTable.put(singleOrder.getId(), singleOrder);
		}

		Set<Integer> tempSet = new HashSet<Integer>();
		int tempId = 0;

		for (ProductionOrder singleOrder : orders)
		{
			tempId = singleOrder.getParentId();
			while (orderHashTable.get(tempId) != null)
			{
				if (!tempSet.add(orderHashTable.get(tempId).getId()))
				{
					throw new IllegalArgumentException(singleOrder.getId() + " has circular dependency");
				}

				tempId = orderHashTable.get(tempId).getParentId();
			}

			tempSet.clear();
		}
	}
}
