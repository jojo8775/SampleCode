package com.samplecode.random.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mprob
{
	public static void main(String[] args)
	{
		ProblemSet1 probSet1 = new ProblemSet1();
		
//		int[] arr = {1,2,3,5,5,5,6,7,7};
//		probSet1.printRepeatedEntries(arr);
		
//		String str = "a cBd Lkm Y";
//		System.out.println(probSet1.sortString(str.toCharArray()));
		
//		int[][] grid ={
//				{0,1,1,0,1},
//				{1,1,1,0,0},
//				{0,0,0,1,1},
//				{1,0,0,1,0}
//		};
//		
//		System.out.println(probSet1.findNumberOfIslands(grid));
		
//		System.out.println(probSet1.formatString("sssssTTTTTToNNps"));
		
		List<ProblemSet1.Node> rr = new ArrayList<ProblemSet1.Node>();
		rr.add(new ProblemSet1.Node(0, 1));
		rr.add(new ProblemSet1.Node(4, 2));
		rr.add(new ProblemSet1.Node(1, 3));
		rr.add(new ProblemSet1.Node(0, 4));
		rr.add(new ProblemSet1.Node(3, 5));
		rr.add(new ProblemSet1.Node(1, 6));
		rr.add(new ProblemSet1.Node(0, 7));
		
		
		Collection<ProblemSet1.Node> result = probSet1.getLeafNodes(rr);
		
		for(ProblemSet1.Node p : result)
		{
			System.out.println(p.getId());
		}
	}
}	

