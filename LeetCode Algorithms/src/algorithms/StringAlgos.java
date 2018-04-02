package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringAlgos
{
	public List<List<String>> GroupAnagrams(String[] strs)
	{
		List<List<String>> list = new ArrayList<List<String>>();
		if (strs.length == 0)
			return list;

		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for (String str : strs)
		{
			String sortedStr = sortString(str);

			if (!map.containsKey(sortedStr))
				map.put(sortedStr, new ArrayList<>());
			map.get(sortedStr).add(str);

		}
		for (String s : map.keySet())
			list.add(map.get(s));

		return list;
	}

	public String sortString(String str)
	{
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public int lengthOfLongestSubstring(String s)
	{
		int len = s.length();
		if (len == 0 || len == 1)
			return len;

		List<Character> list = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < len; i++)
		{
			if (list.contains(s.charAt(i)))
			{
				max = Math.max(max, list.size());
				while (list.get(0) != s.charAt(i))
					list.remove(0);
				list.remove(0);
			}
			list.add(s.charAt(i));
		}

		return Math.max(max, list.size());
	}

	public boolean increasingTriplet(int[] nums)
	{
		int len = nums.length;
		if (len < 3)
			return false;
		int min = Integer.MIN_VALUE;
		int a = min, b = min, c = min;

		for (int i = len - 1; i >= 0; i--)
		{
			if (nums[i] > c)
			{
				c = nums[i];
				b = min;
				a = min;
			}
			else if (nums[i] > b)
			{
				b = nums[i];
				a = min;
			}
			else if (nums[i] != c && nums[i] != b)
				return true;
		}
		return false;
	}

	public List<String> generateParanthesis(int n)
	{
		List<String> list = new ArrayList<>();
		if (n == 0)
			return list;

		int open = 1;

		String s = "{";
		int spaces = 2 * n - 1, maxLen = 2 * n;

		return generateParanthesis(list, s, open, spaces, maxLen);
	}

	public List<String> generateParanthesis(List<String> list, String s, int open, int spaces,
			int maxLen)
	{
		if (s.length() == maxLen)
		{
			list.add(s);
			return list;
		}

		if (open == spaces)
			list = generateParanthesis(list, s + "}", open - 1, spaces - 1, maxLen);
		else
		{
			list = generateParanthesis(list, s + "{", open + 1, spaces - 1, maxLen);
			if (open > 0)
				list = generateParanthesis(list, s + "}", open - 1, spaces - 1, maxLen);
		}
		return list;
	}

}