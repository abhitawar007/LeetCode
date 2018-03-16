package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArraysAndStrings
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

		HashSet<Character> set = new HashSet<>();
		int i = 0, j = 1, max = 1;
		set.add(s.charAt(0));

		while (j < len)
		{
			if (!set.contains(s.charAt(j)))
			{
				set.add(s.charAt(j));
				j++;
			}
			else
			{
				max = Math.max(max, j - i);
				set.clear();
				i++;
				set.add(s.charAt(i));
				j = i + 1;
			}
		}

		return Math.max(max, j - i);
	}

}
