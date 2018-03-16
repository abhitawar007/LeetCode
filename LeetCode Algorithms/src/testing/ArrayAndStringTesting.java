package testing;

import algorithms.ArraysAndStrings;

public class ArrayAndStringTesting
{

	public static void main(String[] args)
	{
		ArraysAndStrings arrayNstr = new ArraysAndStrings();

		// String[] strarray = { "eat", "tea", "tan", "ate", "nat", "bat" };
		// System.out.println(arrayNstr.GroupAnagrams(strarray));

		System.out.println("Longest substring length w/o repeatation : "
				+ arrayNstr.lengthOfLongestSubstring("abcabcbb"));
	}

}
