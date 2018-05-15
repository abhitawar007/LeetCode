package testing;

import algorithms.SortingAlgos;

public class SortingTesting
{

	public static void main(String[] args)
	{
		SortingAlgos sort = new SortingAlgos();

		// ______________________________________________________

		// // Insertion sort
		// int[] nums = { 5, 8, 6, 4, 2, 3, 1, 7 };
		// sort.insertionSort(nums);
		// printArray(nums);
		// ______________________________________________________

		// Binary Insertion sort
		int[] nums = { 5, 8, 6, 4, 2, 3, 1, 7 };
		sort.binarySort(nums);
		printArray(nums);

	}

	public static void printArray(int[] nums)
	{
		System.out.println();
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}

}
