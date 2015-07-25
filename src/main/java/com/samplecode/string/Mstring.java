package com.samplecode.string;

public class Mstring
{
	public static void main(String[] args)
	{
		StringProb prob = new StringProb();
//		System.out.println(prob.isThereAnyDuplicate("abcdswA"));
//		System.out.println(prob.getReverseCString_rec("abc"));
//		System.out.println(prob.getReverseCString_ite("abc"));
//		System.out.println(prob.isRotation("abcde", "cdeab"));
//		System.out.println(prob.isRotation("abcde", "deabc"));
		
//		int[][] grid = createMatrix(9);
//		printMatrix(grid);
//		grid = prob.rotate90(grid);
//		System.out.println("==================================");
//		printMatrix(grid);
		
//		System.out.println(prob.isAnagram("dog", "god"));
		
//		System.out.println(prob.doesDuplicateExists("FOLWUP"));
		
	}

	private static void printMatrix(int[][] arr)
	{
		for(int i=0; i<arr[0].length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				System.out.print(arr[i][j] + ", ");
			}

			System.out.println();
		}
	}
	
	private static int[][] createMatrix(int num)
	{
		int[][] grid = new int[num][];
		
		for(int i=0; i< grid.length; i++)
		{
			grid[i] = new int[grid.length];
			
			for(int j=0; j<grid.length; j++)
			{
				grid[i][j] = i + 1;
			}
		}
		
		return grid;
	}
}
