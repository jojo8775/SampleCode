package com.samplecode.random.dynamicprograming;

public class DynamicProgram
{
	// How many ways 12 can be represented by 2,3,7

	public int findNumberOfWays(int[] pointCatagory, int total)
	{
		int[][] arr = new int[total + 1][];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = new int[pointCatagory.length];
		}

		for (int i = 0; i < pointCatagory.length; i++)
		{
			arr[0][i] = 1;
		}

		for (int i = 1; i <= total; i++)
		{
			for (int j = 0; j < pointCatagory.length; j++)
			{
				int including = (i - pointCatagory[j] >= 0) ? arr[i - pointCatagory[j]][j] : 0;
				int excluding = (j >= 1) ? arr[i][j - 1] : 0;

				arr[i][j] = including + excluding;
			}
		}

		print(arr);

		return arr[total][pointCatagory.length - 1];
	}

	public int findLongestPalindrom(String str)
	{
		return findLongestPalindrom(str, 0, str.length() - 1);
	}

	private int findLongestPalindrom(String str, int start, int end)
	{
		if (start > end)
		{
			return 0;
		}
		
		if(start == end)
		{
			return 1;
		}
		
		if (str.charAt(start) == str.charAt(end) && start + 1 == end)
		{
			return 2;
		}

		if (str.charAt(start) == str.charAt(end))
		{
			return findLongestPalindrom(str, start + 1, end - 1) + 2;
		}

		return Math.max(findLongestPalindrom(str, start + 1, end), findLongestPalindrom(str, start, end - 1));
	}
	
//	private int palindrom()

	private void print(int[][] arr)
	{
		for (int[] aa : arr)
		{
			for (int i : aa)
			{
				System.out.print(i + ", ");
			}
			System.out.println("\n-----------------------------");
		}
	}
}
