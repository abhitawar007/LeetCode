package testing;

import algorithms.ArraysAndStrings;

public class ArrayAndStringTesting
{

	public static void main(String[] args)
	{
		ArraysAndStrings ar = new ArraysAndStrings();

		// String[] strarray = { "eat", "tea", "tan", "ate", "nat", "bat" };
		// System.out.println(arrayNstr.GroupAnagrams(strarray));

		// System.out.println("Longest substring length w/o repeatation : "
		// + arrayNstr.lengthOfLongestSubstring("abcabcbb"));

		// int[] arr = { 1, 2, 2, 1 };
		// System.out.println("Increasing triplet : " +
		// arrayNstr.increasingTriplet(arr));
		// _______________________________________________________
		// System.out.println("Generated paranthesis");
		// System.out.println(arrayNstr.generateParanthesis(3));
		// _______________________________________________________

		// int[] arr = { 3 };
		// int max = ar.removeElement(arr, 3);
		// for (int i = 0; i < max; i++)
		// {
		// System.out.print(arr[i] + " ");
		// }
		// _______________________________________________________

		// Search in rotated sorted array

		int[] arr = { 1, 3 };
		System.out.println("index : " + ar.searchRot(arr, 3));

		// _______________________________________________________
	}

}
