package com.samplecode.sortingandsearching;

public class SortingProb
{
	public int[] merge(int[] arr1, int[] arr2)
	{
		if (arr1.length < arr2.length)
		{
			throw new IllegalArgumentException("arr1 is not big enough to accomodate arr2");
		}

		int bufferStartIndex = 0;
		int maxIndex = arr1.length - 1;

		for (int i = 0; i < arr1.length; i++)
		{
			if (arr1[i] == -1)
			{
				break;
			}

			bufferStartIndex++;
		}

		if ((maxIndex - bufferStartIndex) < arr2.length - 1)
		{
			throw new IllegalArgumentException("arr1 buffer size is not big enough to accomodate arr2");
		}

		int arr1Count = bufferStartIndex - 1;
		int arr2Count = arr2.length - 1;

		while (arr1Count >= 0)
		{
			if (arr2Count >= 0)
			{
				if (arr2[arr2Count] > arr1[arr1Count])
				{
					arr1[maxIndex--] = arr2[arr2Count--];
				}
				else
				{
					arr1[maxIndex--] = arr1[arr1Count--];
				}
			}
			else
			{
				arr1[maxIndex--] = arr1[arr1Count--];
			}
		}

		while (arr2Count >= 0)
		{
			arr1[maxIndex--] = arr2[arr2Count--];
		}

		return arr1;
	}

	public String[] sortAnagram(String[] strArr)
	{
		for (int i = 0; i < strArr.length - 1; i++)
		{
			for (int j = i + 1; j < strArr.length; j++)
			{
				if (isAnagram(strArr[i], strArr[j]))
				{
					if ((i + 1) != j)
					{
						swap(i + 1, j, strArr);
					}
					i++;
				}
			}
		}

		return strArr;
	}

	private boolean isAnagram(String s1, String s2)
	{
		long tempVal1 = 0;
		long tempVal2 = 0;
		long charVal = 0;

		for (char c : s1.toCharArray())
		{
			charVal = c - 'a';
			tempVal1 = tempVal1 | (1 << charVal);
		}

		for (char c : s2.toCharArray())
		{
			charVal = c - 'a';
			tempVal2 = tempVal2 | (1 << charVal);
		}

		return tempVal1 == tempVal2;
	}

	private void swap(int index1, int index2, String[] strArr)
	{
		String temp = strArr[index1];
		strArr[index1] = strArr[index2];
		strArr[index2] = temp;
	}

	public int findElement(int[] arr, int num)
	{
		if (arr.length == 0)
		{
			return -1;
		}

		return findElementHelper(0, arr.length - 1, arr, num);
	}

	private int findElementHelper(int beg, int end, int[] arr, int num)
	{
		if (beg > end)
		{
			return -1;
		}

		int middle = (beg + end) / 2;

		if (num == arr[middle])
		{
			return middle;
		}

		if (num > arr[middle])
		{
			if (num > arr[end] && arr[end] > arr[middle])
			{
				// go left
				return findElementHelper(beg, middle - 1, arr, num);
			}

			// go right
			return findElementHelper(middle + 1, end, arr, num);
		}
		else
		{
			if (num < arr[end])
			{
				// go right
				return findElementHelper(middle + 1, end, arr, num);
			}

			// go left
			return findElementHelper(beg, middle - 1, arr, num);
		}
	}
}
