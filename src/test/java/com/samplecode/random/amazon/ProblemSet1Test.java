package com.samplecode.random.amazon;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.samplecode.random.amazon.ProblemSet1.Node;

public class ProblemSet1Test
{
	@Test(expected = IllegalArgumentException.class)
	public void testFormatStringNullInput()
	{
		new ProblemSet1().formatString(null);
	}

	@Test
	public void testFormatStringEmptyInput()
	{
		assertThat(new ProblemSet1().formatString(""), is(""));
	}

	@Test
	public void testFormatStringWithoutConsecutiveRepeatCharacter()
	{
		assertThat(new ProblemSet1().formatString("abdesvtb"), is("abdesvtb"));
		assertThat(new ProblemSet1().formatString("1232zb342"), is("1232zb342"));
		assertThat(new ProblemSet1().formatString("ab de svtb"), is("ab de svtb"));
	}

	@Test
	public void testFormatStringWithConsecutiveRepeatCharacter()
	{
		assertThat(new ProblemSet1().formatString("aabdeeesvvvvt"), is("a2bde3sv4t"));
		assertThat(new ProblemSet1().formatString("aabdeee3333332svvvvt"), is("a2bde3362sv4t"));
		assertThat(new ProblemSet1().formatString("aabdeee     2svvvvt"), is("a2bde3 52sv4t"));
	}

	@Test
	public void testFormatStringWithConsecutiveRepeatCharacterAtEnd()
	{
		assertThat(new ProblemSet1().formatString("aabdeeesvvvvttttt"), is("a2bde3sv4t5"));
	}

	@Test
	public void testFormatStringWithNonRepeatingConsecutiveCharacterAtEnd()
	{
		assertThat(new ProblemSet1().formatString("aabdeeesvvvvt"), is("a2bde3sv4t"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void getLeafProductionOrdersNullInput()
	{
		new ProblemSet1().getLeafNodes(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getLeafProductionOrdersNullEntry()
	{
		new ProblemSet1().getLeafNodes(Arrays.asList(new Node(1, 2), null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void getLeafProductionOrderCircularDependency()
	{
		new ProblemSet1().getLeafNodes(Arrays.asList(new Node(1, 2), new Node(2, 1)));
	}

	@Test
	public void getLeafProductionOrderSingleOrder()
	{
		List<Node> orders = Arrays.asList(new Node(1, 2));
		assertThat(new ProblemSet1().getLeafNodes(orders), is((Collection<Node>) orders));
	}

	@Test
	public void getLeafProductionOrder()
	{
		List<Node> orders = new ArrayList<Node>(7);
		orders.add(new ProblemSet1.Node(0, 1));
		orders.add(new ProblemSet1.Node(4, 2));
		orders.add(new ProblemSet1.Node(1, 3));
		orders.add(new ProblemSet1.Node(0, 4));
		orders.add(new ProblemSet1.Node(3, 5));
		orders.add(new ProblemSet1.Node(1, 6));
		orders.add(new ProblemSet1.Node(0, 7));
		
		List<Node> leafOrders = new ArrayList<Node>();
		leafOrders.add(new ProblemSet1.Node(4, 2));
		leafOrders.add(new ProblemSet1.Node(1, 6));
		leafOrders.add(new ProblemSet1.Node(3, 5));
		leafOrders.add(new ProblemSet1.Node(0, 7));

		Collection<Node> actualLeafOrders = new ProblemSet1().getLeafNodes(orders);
		
		boolean found = false;
		for(Node actualSingleOrder : actualLeafOrders)
		{
			for(Node singleOrder : leafOrders)
			{
				if(actualSingleOrder.equals(singleOrder))
				{
					found = true;
					break;
				}
			}
			
			if(!found)
			{
				fail("Expected leaf orders didnt match actual leaf orders");
			}
			
			found = false;
		}
	}
}
