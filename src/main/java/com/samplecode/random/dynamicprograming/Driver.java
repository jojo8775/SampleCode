package com.samplecode.random.dynamicprograming;

public class Driver
{
	public static void main(String[] args)
	{
		DynamicProgram dynamicProgram = new DynamicProgram();
		
//		int[] arr = {2,5,3,6};
//		System.out.println(dynamicProgram.findNumberOfWays(arr, 10));
		
		String s = "MADXEAM";
		System.out.println(dynamicProgram.findLongestPalindrom(s));
	}
}
