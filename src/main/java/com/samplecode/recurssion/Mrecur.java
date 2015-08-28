package com.samplecode.recurssion;

import java.util.List;

public class Mrecur
{
	public static void main(String[] args)
	{
		Recurssion recurssion = new Recurssion();

		// System.out.println(recurssion.findNthFibbonacciNum_ite(5));

		// int arr[] = {1, 2, 3};
		// int m = 3;
		// int n = 4;
		// recurssion.count(arr, m, n);

		// System.out.println(recurssion.findNumberOfpath(createBoard(5)));

		// List<String> result = recurssion.findSubSet("abcd");
		// List<String> result = recurssion.findSubSet_rec("abcd");

		// List<String> result = recurssion.findPermutation("abc");

		// List<String> result = recurssion.findCombinations(3);
		// for (String s : result)
		// {
		// System.out.println(s);
		// }

		// int[] coinType = { 1, 2, 3 };
		// System.out.println(recurssion.findNumberOfWays_rec(4, coinType));
		// System.out.println(recurssion.findNumberOfWays_dp(4, coinType));
		
		recurssion.findAllNqueen(14);
	}

	private static int[][] createBoard(int num)
	{
		int[][] grid = new int[num][];

		for (int i = 0; i < num; i++)
		{
			grid[i] = new int[num];
		}

		return grid;
	}
}
