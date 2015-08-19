package com.samplecode.stack;

import java.lang.reflect.Array;

public class ArrayStack<T>
{
	private T[] arr;

	int stack1head = 0;
	int stack2head = 0;
	int stack3head = 0;
	int refHead1;
	int refHead2;
	int refHead3;

	@SuppressWarnings("unchecked")
	public ArrayStack(Class clazz, int size)
	{
		if (size < 3)
		{
			throw new IllegalArgumentException("Size has to be more than 3");
		}

		arr = (T[]) Array.newInstance(clazz, size);

		refHead1 = (size / 3) - 1;
		refHead2 = (2 * (size / 3)) - 1;
		refHead3 = size - 1;

		stack1head = refHead1 + 1;
		stack2head = refHead2 + 1;
		stack3head = refHead3 + 1;
	}

	public void pushStackOne(T val)
	{
		if (stack1head == 0)
		{
			System.out.println("Stack one is full.");
			return;
		}

		arr[--stack1head] = val;
	}

	public T popStackOne()
	{
		if (stack1head > refHead1)
		{
			System.out.println("Stack one is empty");
			return null;
		}

		return arr[stack1head++];
	}

	public T peekStackOne()
	{
		if (stack1head > refHead1)
		{
			System.out.println("Stack one is empty");
			return null;
		}

		return arr[stack1head];
	}

	public void pushStackTwo(T val)
	{
		if (stack2head == (refHead1 + 1))
		{
			System.out.println("Stack two is full.");
			return;
		}

		arr[--stack2head] = val;
	}

	public T popStackTwo()
	{
		if (stack2head > refHead2)
		{
			System.out.println("Stack two is empty");
			return null;
		}

		return arr[stack2head++];
	}

	public T peekStackTwo()
	{
		if (stack2head > refHead2)
		{
			System.out.println("Stack two is empty");
			return null;
		}

		return arr[stack2head];
	}

	public void pushStackThree(T val)
	{
		if (stack3head == (refHead2 + 1))
		{
			System.out.println("Stack three is full.");
			return;
		}

		arr[--stack3head] = val;
	}

	public T popStackThree()
	{
		if (stack3head > refHead3)
		{
			System.out.println("Stack three is empty");
			return null;
		}

		return arr[stack3head++];
	}

	public T peekStackThree()
	{
		if (stack3head > refHead3)
		{
			System.out.println("Stack three is empty");
			return null;
		}

		return arr[stack3head];
	}
}
