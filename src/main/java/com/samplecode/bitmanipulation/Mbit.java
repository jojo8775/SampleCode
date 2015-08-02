package com.samplecode.bitmanipulation;

public class Mbit
{
	public static void main(String[] args)
	{
		BitManipulation bit = new BitManipulation();
//		System.out.println(bit.add(5, 6));
//		System.out.println(bit.negate(8));
//		System.out.println(bit.minus(5, 6));
//		System.out.println(bit.modulus(1, 3));
		
//		printBinary(bit.subBit(9, 1));
//		printBinary(bit.merge(9, 3, 3, 2));
		
		printBinary(bit.swapBits(9));
	}
	
	private static void printBinary(int num)
	{
		if(num == 0)
		{
			return;
		}

		printBinary(num/2);

		System.out.print(" " + num%2);
	}
}
