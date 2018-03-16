package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
}
