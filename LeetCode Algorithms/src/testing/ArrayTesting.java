package testing;

import algorithms.ArrayAlgos;

public class ArrayTesting
{

	public static void main(String[] args)
	{
		ArrayAlgos ar = new ArrayAlgos();
		// int[] arr = { 3 };
		// int max = ar.removeElement(arr, 3);
		// for (int i = 0; i < max; i++)
		// {
		// System.out.print(arr[i] + " ");
		// }
		// _______________________________________________________

		// Search in rotated sorted array

		// int[] arr = { 1, 3 };
		// System.out.println("index : " + ar.searchRot(arr, 3));

		// _______________________________________________________

		// Flood Fill
		// int[][] image = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 },
		// { 1, 0, 0, 1, 1, 0, 1, 1 }, { 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0,
		// 1, 0 },
		// { 1, 1, 1, 2, 2, 2, 2, 0 }, { 1, 1, 1, 1, 1, 2, 1, 1 },
		// { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		// ar.floodFill(image, 4, 4, 3);
		// printDoubleArray(image);

		// _______________________________________________________

		// Count of smaller number after self
		// int[] nums = { 5, 2, 6, 1 };
		// int[] nums = { 3, 4, 3, 8, 4, 3, 5 };
		// System.out.println(ar.countSmaller(nums));

		// _______________________________________________________

		// Top K frequent numbers
		// String[] arr = { "i", "love", "leetcode", "i", "love", "coding" };
		// System.out.println(ar.topKFrequent(arr, 2));

		// _______________________________________________________

		// int[] nums = { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 };
		// System.out.println(ar.findDuplicate(nums));

		// _______________________________________________________
		// Rotate array

		// int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		// ar.rotate(nums, 3);
		// ar.print(nums);
		// _______________________________________________________

		// Threesome closest
		// int[] nums = { 0, 2, 1, -3 };
		// System.out.println(ar.threeSumClosest(nums, 1));
		// _______________________________________________________

		// Third largest number
		// int[] nums = { 1, -2147483648, 2 };
		// System.out.println(ar.thirdMax(nums));

		// _______________________________________________________

		// Top k frequent elements
		// int[] nums = { 1, 1, 1, 2, 2, 3 };
		// System.out.println(ar.topKFrequent(nums, 2));
		// _______________________________________________________

		// Find shortes unsorted subarray length
		// int[] nums = { 2, 3, 3, 2, 4 };
		// System.out.println(ar.findUnsortedSubarray(nums));

		// _______________________________________________________

		// check if subarray sum i multiples of k
		int[] nums = { 1, 2 };
		System.out.println(ar.checkSubArray(nums, 3));
	}

	public static void printDoubleArray(int[][] arr)
	{
		if (arr.length == 0)
			return;

		for (int i = 0; i < arr.length; i++)
		{
			System.out.println();
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
		}
	}

}
