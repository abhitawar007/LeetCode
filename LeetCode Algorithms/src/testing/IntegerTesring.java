package testing;

import algorithms.IntegerAlgos;

public class IntegerTesring
{
	public static void main(String[] args)
	{
		IntegerAlgos in = new IntegerAlgos();

		// __________________________________________________________

		// Multiply w/o *
		// System.out.println("Multiplication : " + in.multiply(7, 9));
		// __________________________________________________________

		// Permutation
		// int[] nums = { 1, 2, 3 };
		// System.out.println("Permutation: " + in.permute(nums));
		// __________________________________________________________

		// Permutation 2
		int[] nums = { 1, 1, 2, 2, 2 };
		System.out.println("Unique permutation : " + in.permuteUnique(nums));
	}
}
