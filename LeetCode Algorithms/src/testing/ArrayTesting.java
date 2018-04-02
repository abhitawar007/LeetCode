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
		int[][] image = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 0, 0, 1, 1, 0, 1, 1 }, { 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 },
				{ 1, 1, 1, 2, 2, 2, 2, 0 }, { 1, 1, 1, 1, 1, 2, 1, 1 },
				{ 1, 1, 1, 1, 1, 2, 2, 1 }, };
		ar.floodFill(image, 4, 4, 3);
		printDoubleArray(image);
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