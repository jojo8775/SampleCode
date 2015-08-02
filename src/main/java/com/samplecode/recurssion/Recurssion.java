package com.samplecode.recurssion;

import java.util.ArrayList;
import java.util.List;

public class Recurssion
{
	public int findNthFibbonacciNum_ite(int num)
	{
		if (num < 1)
		{
			throw new IllegalArgumentException("Input cannot be zero or negative.");
		}

		int prevNumber = -1;
		int currentNumber = 1;
		int temp = 0;

		while (num >= 0)
		{
			temp = currentNumber;
			currentNumber = currentNumber + prevNumber;
			prevNumber = temp;
			num--;
		}

		return currentNumber;
	}

	public int findNthFibbonacciNum_rec(int num)
	{
		if (num < 1)
		{
			throw new IllegalArgumentException("Input cannot be Zero or negative.");
		}

		return findNthNumberHelper(1, -1, num);
	}

	private int findNthNumberHelper(int current, int prev, int num)
	{
		if (num == 0)
		{
			return current;
		}

		int temp = current;
		current = prev + current;
		prev = temp;

		return findNthNumberHelper(current, prev, num - 1);
	}

	public int count(int S[], int m, int n)
	{
		int i, j, x, y;

		// We need n+1 rows as the table is consturcted in bottom up manner
		// using
		// the base case 0 value case (n = 0)
		int[][] table = new int[n + 1][];
		for (int tc = 0; tc < table.length; tc++)
		{
			table[tc] = new int[m];
		}

		// Fill the enteries for 0 value case (n = 0)
		for (i = 0; i < m; i++)
			table[0][i] = 1;

		// Fill rest of the table enteries in bottom up manner
		for (i = 1; i < n + 1; i++)
		{
			for (j = 0; j < m; j++)
			{
				// Count of solutions including S[j]
				x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

				// Count of solutions excluding S[j]
				y = (j >= 1) ? table[i][j - 1] : 0;

				// total count
				table[i][j] = x + y;
			}
		}
		return table[n][m - 1];
	}

	// find the number of path dynamic programming
	public int findNumberOfpath(int[][] board)
	{
		int numberOfMoves = (board.length - 1) * 2;
		int rightMoves = board.length - 1;

		int[][] table = new int[numberOfMoves + 1][];

		for (int i = 0; i < numberOfMoves + 1; i++)
		{
			table[i] = new int[rightMoves];
		}

		// number of ways to chose n from m when m = 0 is 1
		for (int i = 0; i < numberOfMoves - 1; i++)
		{
			table[i][0] = 1;
		}

		// number of ways to chose n from m when m = n is 1
		for (int i = 0; i < rightMoves; i++)
		{
			table[i][i] = 1;
		}

		// compute
		for (int i = 2; i < numberOfMoves + 1; i++)
		{
			for (int j = 1; j < rightMoves; j++)
			{
				table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
			}
		}

		return table[numberOfMoves][rightMoves - 1];
	}

	public List<String> findSubSet(String str)
	{
		int tempVal = 0;
		char[] charArr = str.toCharArray();
		List<String> result = new ArrayList<String>();
		int index = 0;
		int maxVal = 1 << str.length();

		for (int i = 0; i < maxVal; i++)
		{
			StringBuilder sb = new StringBuilder();
			tempVal = i;

			index = 0;
			while (tempVal > 0)
			{
				if ((tempVal & 1) > 0)
				{
					sb.append(charArr[index]);
				}

				tempVal = tempVal >> 1;
				index++;
			}

			result.add(sb.toString());
		}

		return result;
	}

	public List<String> findSubSet_rec(String str)
	{
		List<String> result = new ArrayList<String>();
		findSubSetHelper("", str, result);
		return result;
	}

	private void findSubSetHelper(String soFar, String rest, List<String> result)
	{
		if (rest.equals(""))
		{
			result.add(soFar);
			return;
		}

		String next = soFar + rest.charAt(0);
		String remaining = rest.substring(1, rest.length());
		findSubSetHelper(soFar, remaining, result);
		findSubSetHelper(next, remaining, result);
	}

	public List<String> findPermutation(String str)
	{
		List<String> result = new ArrayList<String>();
		findPermutationHelper("", str, result);
		return result;
	}

	private void findPermutationHelper(String soFar, String rest, List<String> result)
	{
		if (rest.equals(""))
		{
			result.add(soFar);
			return;
		}

		for (int i = 0; i < rest.length(); i++)
		{
			String remaining = rest.substring(0, i) + rest.substring(i + 1, rest.length());
			findPermutationHelper(soFar + rest.charAt(i), remaining, result);
		}
	}

	public List<String> findCombinations(int num)
	{
		char[] charArr = new char[num * 2];
		List<String> result = new ArrayList<String>();

		findCombinationHelper(charArr, 0, num, num, result);

		return result;
	}

	private void findCombinationHelper(char[] charArr, int charIndex, int leftBracket, int rightBracket,
			List<String> result)
	{
		if (leftBracket > rightBracket)
		{
			return;
		}

		if (rightBracket == 0)
		{
			result.add(String.copyValueOf(charArr));
			return;
		}

		if (leftBracket > 0)
		{
			charArr[charIndex] = '(';
			findCombinationHelper(charArr, charIndex + 1, leftBracket - 1, rightBracket, result);
		}

		if (rightBracket > 0)
		{
			charArr[charIndex] = ')';
			findCombinationHelper(charArr, charIndex + 1, leftBracket, rightBracket - 1, result);
		}

		charArr[charIndex] = ' ';
	}
	
	int existingColor;
	int replaceColor;

	public void fillColor(int[][] canvas, int existingColor, int replaceColor, int x, int y)
	{
		this.replaceColor = replaceColor;
		this.existingColor = existingColor;

		fillColorHelper(canvas, x, y, canvas[0].length - 1, canvas.length - 1);
	}

	private void fillColorHelper(int[][] canvas, int x, int y, int maxWidth, int maxHeight)
	{
		if(x> maxHeight || x<0 || y>maxWidth || y < 0)
		{
			return;
		}

		if(canvas[x][y] != existingColor)
		{
			return;
		}

		canvas[x][y] = replaceColor;

		//go down
		fillColorHelper(canvas, x+1, y, maxWidth, maxHeight);

		//go left
		fillColorHelper(canvas, x, y-1, maxWidth, maxHeight);

		//go right
		fillColorHelper(canvas, x, y+1, maxWidth, maxHeight);

		//go up
		fillColorHelper(canvas, x-1, y, maxWidth, maxHeight);
	}
	
	public int findNumberOfWays_dp(int amount, int[] coinType)
	{
		int[][] table = new int[amount + 1][];

		for(int i=0; i<amount + 1; i++)
		{
			table[i] = new int[coinType.length];
		}

		//there only one way to represent 0 by not choosing any coins. 
		for(int i=0; i<coinType.length; i++)
		{
			table[0][i] = 1;
		}

		int x = 0;
		int y = 0;

		for(int i=1; i<amount + 1; i++)
		{

			for(int j=0; j<coinType.length; j++)
			{
				//taking a specific coin
				x = (i - coinType[j] >= 0) ? table[i-coinType[j]][j] : 0;

				//without taking a specific coin
				y = j>0 ? table[i][j-1] : 0; 

				table[i][j] = x+y;
			}

		}

		return table[amount][coinType.length - 1];
	}

	public int findNumberOfWays_rec(int amount, int[] coinType)
	{
		return findNWays(coinType, amount, coinType.length - 1);
	}

	private int findNWays(int[] coinType, int amount, int coinIndex)
	{

		//we can chose 0 coins to represent 0 sum
		if(amount == 0)
		{
			return 1;
		}

		//thers is no way to represent a negative sum
		if(amount < 0)
		{
			return 0;
		}

		//there is no way to represent a sum with 0 coins
		if(coinIndex < 0 && amount > 0)
		{
			return 0;
		}

		return findNWays(coinType, amount - coinType[coinIndex], coinIndex) + findNWays(coinType, amount, coinIndex - 1);
	}
	
	public void findAllNqueen(int num)
	{
		if(num < 4)
		{
			throw new IllegalArgumentException("Input cannot be less than 4");
		}

		findAllNQueen(num, 0, new int[num]);
	}


	private void findAllNQueen(int num, int col, int[] queenPerCol)
	{
		if(col == num)
		{
			printNQueenBoard(queenPerCol);
			return;
		}

		for(int i=0; i<num; i++)
		{
			queenPerCol[col] = i;

			if(isSafe(i,col,queenPerCol))
			{
				findAllNQueen(num, col + 1, queenPerCol);
			}

			queenPerCol[col] = 0;
		}
	}

	private boolean isSafe(int row, int col, int[] queenPerCol)
	{
		for(int i=col-1; i>=0; i--)
		{
			//finding is there is any queen in a row.
			if(queenPerCol[i] == row)
			{
				return false;
			}

			//checking the diagonals
			if((col - i) == (Math.abs(queenPerCol[i] - queenPerCol[col])))
			{
				return false;
			}
		}	
		
		return true;
	}

	private void printNQueenBoard(int[] board)
	{
		int boardSize = board.length;

		for(int i=0; i<boardSize; i++)
		{
			for(int j=0; j<boardSize; j++)
			{
				if(j == board[i])
				{
					System.out.print("1");
				}
				else
				{
					System.out.print("0");
				}
			}

			System.out.println();
		}

		System.out.println("=========================");
	}

}
