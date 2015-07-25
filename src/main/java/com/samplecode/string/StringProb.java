package com.samplecode.string;

public class StringProb
{
	public boolean isThereAnyDuplicate(String str)
	{

		int[] arr = new int[256];

		for (char singleChar : str.toCharArray())
		{
			if (arr[singleChar] != 0)
			{
				return true;
			}

			arr[singleChar] = singleChar;
		}

		return false;
	}
	
	public String getReverseCString_rec(String str)
	{
		if(str == null)
		{
			return null;
		}

		return getReverseCString("/0", str);
	}

	private String getReverseCString(String soFar, String rest)
	{
		if(rest.isEmpty())
		{
			return soFar;
		}

		soFar = soFar + rest.substring(rest.length() - 1);
		rest = rest.substring(0, rest.length() - 1);

		return getReverseCString(soFar, rest);
	}
	
	public String getReverseCString_ite(String str)
	{
		if(str == null)
		{
			return null;
		}

		char[] charArr = str.toCharArray();

		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("/0");

		for(int i=charArr.length - 1; i>=0; i--)
		{
			sBuilder.append(charArr[i]);
		}

		return sBuilder.toString();
	}
	
	public boolean isRotation(String s1, String s2)
	{
		if(s1 == null || s2 == null)
		{
			return false;
		}


		if(s1.length() != s2.length())
		{
			return false;
		}

		int startIndex = -1;
		int s2Index = 0;

		for(int i=0; i<s1.length();i++)
		{
			if(s1.charAt(i) == s2.charAt(s2Index))
			{
				if(startIndex == -1)
				{
					startIndex = i;
				}

				s2Index ++;
			}

			else
			{
				startIndex = -1;
			}
		}

		if(startIndex == -1)
		{
			return false;
		}

		return isSubString(s1.substring(startIndex, s1.length()) + s1.substring(0,startIndex), s2);
	}
	
	private boolean isSubString(String s1, String s2)
	{
		return s1.equals(s2);
	}
	
	public int[][] rotate90(int[][] input)
	{
		int tempElement = 0;

		for(int loop =0; loop < (input.length/2); loop ++)
		{
			for(int i=loop; i < (input.length - loop - 1); i++)
			{
				tempElement = input[loop][i];

				input[loop][i] = input[input.length - i - 1][loop];

				input[input.length - i - 1][loop] = input[input.length - loop - 1][input.length - i - 1];

				input[input.length - loop - 1][input.length - i - 1] = input[i][input.length - loop - 1];

				input[i][input.length - loop - 1] = tempElement;
			}
		}

		return input;
	}
	
	public boolean isAnagram(String str1, String str2)
	{
		int[] arr = new int[256];

		for(char singleChar : str1.toCharArray())
		{
			arr[singleChar] += 1;
		}

		for(char singleChar : str2.toCharArray())
		{
			if(arr[singleChar] == 0)
			{
				return false;
			}

			arr[singleChar] -= 1;
		}

		return true;
	}
	
	public String filterSpaces(String str1)
	{
		StringBuilder sBuilder = new StringBuilder();

		for(char singleChar : str1.toCharArray())
		{
			if(singleChar == ' ')
			{
				sBuilder.append("%20");
			}
			else
			{
				sBuilder.append(singleChar);
			}
		}

		return sBuilder.toString();
	}
	
	public boolean doesDuplicateExists(String str)
	{
		int index = 0;
		int val;

		for(char singleChar : str.toCharArray())
		{
			val = singleChar - 'a';

			if((index & (1 << val)) > 0)
			{
				return true;
			}

			index |= (1 << val);
		}

		return false;
	}
}
