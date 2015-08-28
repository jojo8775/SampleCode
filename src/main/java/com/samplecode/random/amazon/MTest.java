package com.samplecode.random.amazon;

import java.util.HashMap;
import java.util.Map;

public class MTest
{
	public static void main(String[] args)
	{
		Map<Integer, P> m = new HashMap<Integer, P>();
		m.put(101, new P());
		
	}
	
	public static class P
	{
		int height = 10;
		int weight = 20;
	}
}


