package com.samplecode.multithread;

public class M
{
	public static void main(String[] args)
	{
//		ThreadTest t = new ThreadTest();
//		t.print("A");
		
		for(int i=0; i<10; i++)
		{
			(new Thread(new RunnerTest("C" + (i+1)))).start();
		}
	}
	
	public static class RunnerTest  implements Runnable
	{
		private String consumer;
		ThreadTest t = new ThreadTest();
		
		public RunnerTest(String consumer)
		{
			this.consumer = consumer;
		}
		
		@Override
		public void run()
		{
			t.print(consumer);
		}
	}
}
