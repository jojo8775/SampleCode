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
			if (num < arr[end])
			{
				// go left
				return findElementHelper(beg, middle - 1, arr, num);
			}

			// go right
			return findElementHelper(middle + 1, end, arr, num);
		}
		else
		{
			if (num < arr[beg])
			{
				// go right
				return findElementHelper(middle + 1, end, arr, num);
			}

			// go left
			return findElementHelper(beg, middle - 1, arr, num);
		}
	}

	public int findIndex(int[] arr, int key)
	{
		return indexFinder(arr, 0, arr.length - 1, key);
	}

	private int indexFinder(int[] arr, int beg, int end, int key)
	{
		if (beg > end)
		{
			return -1;
		}

		int middle = (beg + end) / 2;
		int middleVal = arr[middle];

		if (middleVal == key)
		{
			return middle;
		}

		if (key > middleVal)
		{
			if (key > arr[end])
			{
				// look left;
				return indexFinder(arr, beg, middle - 1, key);
			}
			// look right
			return indexFinder(arr, middle + 1, end, key);
		}
		else
		{
			if (key < arr[beg])
			{
				// look right
				return indexFinder(arr, middle + 1, end, key);
			}
			// look left
			return indexFinder(arr, beg, middle - 1, key);
		}
	}

	public int search(int[] arr, int key)
	{
		return searchHelper(arr, 0, arr.length - 1, key);
	}

	private int searchHelper(int arr[], int beg, int end, int key)
	{
		while (beg <= end)
		{
			int middle = (beg + end) / 2;

			if (key == arr[middle])
			{
				return middle;

			}

			if (arr[beg] <= arr[middle])
			{
				if (key > arr[middle])
				{
					beg = middle + 1;

				}
				else if (key >= arr[beg])
				{
					end = middle - 1;

				}
				else
				{
					beg = middle + 1;
				}
			}
			else if (key < arr[middle])
			{
				end = middle - 1;
			}
			else if (key <= arr[end])
			{
				beg = middle + 1;
			}
			else
			{
				end = middle - 1;
			}

		}

		return -1;
	}

	public int search_mod(int[] arr, int key)
	{
		int beg = 0;
		int end = arr.length - 1;
		int middle = 0;

		while (beg <= end)
		{
			middle = (beg + end) / 2;

			if (key == arr[middle])
			{
				return middle;
			}
			
			if(arr[middle] >= arr[beg])
			{
				if(key > arr[middle])
				{
					beg = middle + 1;
				}
				else if(key >= arr[beg])
				{
					end = middle - 1;
				}
				else
				{
					beg = middle + 1;
				}
			}
			else if(key >= arr[beg])
			{
				end = middle - 1;
			}
			else if(key > arr[middle])
			{
				beg = middle + 1;
			}
			else
			{
				end = middle - 1;
			}
		}
		
		return -1;
	}
}
