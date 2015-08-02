package com.samplecode.bitmanipulation;

public class BitManipulation
{
	public int add(int a, int b)
	{
		int carry = 0;

		while (true)
		{
			carry = a & b;

			a = a ^ b;

			if (carry == 0)
			{
				break;
			}

			b = carry << 1;
		}

		return a;
	}

	public int negate(int a)
	{
		return add(~a, 1);
	}

	public int minus(int a, int b)
	{
		return add(a, negate(b));
	}

	public int modulus(int a, int b)
	{
		b = Math.abs(b);
		a = Math.abs(a);

		while (a >= b)
		{
			a = minus(a, b);
		}

		return a;
	}

	public int subBit(int a, int pos)
	{
		int b = a >> pos;
		b = b << pos;
		return a ^ b;
	}

	public int merge(int num1, int num2, int start, int end)
	{
		int tempVal = num1 >> end;
		tempVal = tempVal << end;

		int seqToAppend = num1 ^ tempVal;

		num1 = num1 & (1 << start);
		num1 = num1 | (num2 << (end - 1));
		return num1 | seqToAppend;
	}

	public int swapBits(int num)
	{
		int tempVal = num & (num << 1);
		tempVal = tempVal | (num << 1);
		tempVal = tempVal & (num >> 1);
		
		return tempVal | (num >> 1);
	}
}
