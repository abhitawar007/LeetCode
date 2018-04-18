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

	public String licenseKeyFormatting(String S, int K)
	{
		String ans = "";
		int j = 0;
		for (int i = S.length() - 1; i >= 0; i--)
		{
			if (S.charAt(i) == '-')
				continue;
			if (j != 0 && j % K == 0)// && i != 0 && ans.charAt(0) != '-')
				ans = "-" + ans;
			ans = Character.toUpperCase(S.charAt(i)) + ans;
			j++;
		}
		return ans;
	}

	private String s = "";
	private int lo = 0, hi = 0, max = 0;

	public String longestPalindrome(String str)
	{
		s = str;

		for (int i = 0; i < s.length(); i++)
		{
			findPalindrome(i, i);
			findPalindrome(i, i + 1);
		}

		System.out.println("lo : " + lo + "hi : " + hi);

		return s.substring(lo, hi);
	}

	public void findPalindrome(int m, int n)
	{
		while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n))
		{
			m--;
			n++;
		}

		if (n - m > max)
		{
			lo = m + 1;
			hi = n;
			max = hi - lo;
		}
	}

}
