package com.samplecode.sortingandsearching;

public class Sorting
{
	public int[] mergeSort(int[] arr)
	{
		if (arr.length == 0 || arr.length == 1)
		{
			return arr;
		}

		mergeSortHelper(0, arr.length - 1, arr);
		return arr;
	}

	private void mergeSortHelper(int beg, int end, int[] arr)
	{
		if (beg >= end)
		{
			return;
		}

		int middle = (beg + end) / 2;
		mergeSortHelper(beg, middle, arr);
		mergeSortHelper(middle + 1, end, arr);
		merge(beg, end, middle, arr);
	}

	private void merge(int beg, int end, int middle, int[] arr)
	{
		int[] leftArr = new int[middle - beg + 1];
		int[] rightArr = new int[end - middle];

		int leftCount = 0;
		int rightCount = 0;

		for (int i = beg; i <= middle; i++)
		{
			leftArr[leftCount++] = arr[i];
		}

		for (int i = middle + 1; i <= end; i++)
		{
			rightArr[rightCount++] = arr[i];
		}

		leftCount = 0;
		rightCount = 0;

		int index = beg;

		while (leftCount < leftArr.length)
		{
			if (rightCount < rightArr.length)
			{
				if (leftArr[leftCount] > rightArr[rightCount])
				{
					arr[index++] = rightArr[rightCount++];
				}
				else
				{
					arr[index++] = leftArr[leftCount++];
				}
			}
			else
			{
				arr[index++] = leftArr[leftCount++];
			}
		}

		while (rightCount < rightArr.length)
		{
			arr[index++] = rightArr[rightCount++];
		}
	}

	public int[] quickSort(int[] arr)
	{
		if(arr.length == 0 || arr.length == 1)
		{
			return arr;
		}

		quickSort(arr, 0, arr.length - 1);

		return arr;
	}

	private void quickSort(int[] arr, int min, int max)
	{
		if(min >= max)
		{
			return;
		}

		int pivot = findPivot(min, max, arr);
		quickSort(arr, min, pivot - 1);
		quickSort(arr, pivot + 1, max);
	}

	private int findPivot(int min, int max, int[] arr)
	{
		int pivot = (int) (Math.random()* (max - min + 1)) + min;
		swap(pivot, max, arr);
		pivot = max;
		int index = min - 1;

		for(int i= min; i<max; i++)
		{
			if(arr[i] <= arr[pivot])
			{
				index++;
				if(index != i)
				{
					swap(index, i, arr);
				}
			}
		}

		swap(index+1, pivot, arr);
	 
		return index + 1;
	}


	private void swap(int index1, int index2, int[] arr)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public int[] selectionSort(int[] arr)
	{
		int minIndex = 0;

		for(int i=0;i<arr.length -1; i++)
		{
			minIndex = i;
			
			for(int j=i; j<arr.length; j++)
			{
				if(arr[minIndex] > arr[j])
				{
					minIndex = j;
				}
			}

			if(minIndex != i)
			{
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		
		return arr;
	}
	
	public int[] insertionSort(int[] arr)
	{
		int count = 0;
		
		int index = 0;
		for(int i=1; i<arr.length; i++)
		{
			index = i;
			for(int j=i-1; j>=0;j--)
			{
				if(arr[j] <= arr[index])
				{
					break;
				}

				int temp = arr[j];
				arr[j] = arr[index];
				arr[index] = temp;
				index--;
				count ++;
			}
		}

		System.out.println("swaped : " + count + " times");
		return arr;
	}
}
