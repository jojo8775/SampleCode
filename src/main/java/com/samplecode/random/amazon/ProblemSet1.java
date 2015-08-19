package com.samplecode.random.amazon;

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

		if(sameCharCount > 1)
		{
			stringBuilder.append(sameCharCount);
		}

		return stringBuilder.toString();
	}
}
