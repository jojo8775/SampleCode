package com.samplecode.multithread;

public class ThreadTest
{
	private static int COUNT = 0;
	
	public void print(String consumer)
	{
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service: " + consumer + " : " + COUNT++);
	}
}
