package algorithms;

public class IntegerAlgos
{
	public int multiply(int a, int b)
	{
		// CTCI 8.5: Write recursive function to multiply a and b without using * or /.
		// Use rest of the operators as minimum times as possible

		if (a == 0 || b == 0)
			return 0;
		int smaller = a < b ? a : b;
		int bigger = b > a ? b : a;

		int[] memo = new int[smaller + 1];

		return multiplyHelper(smaller, bigger, memo);
	}

	private int multiplyHelper(int smaller, int bigger, int[] memo)
	{
		if (smaller == 0)
			return 0;
		if (smaller == 1)
			return bigger;
		if (memo[smaller] > 0)
			return memo[smaller];

		int halfsmall = smaller >> 1; // Divide smaller by 2

		int side1 = multiplyHelper(halfsmall, bigger, memo);
		int side2 = smaller % 2 == 0 ? side1 : multiplyHelper(smaller - halfsmall, bigger, memo);

		memo[smaller] = side1 + side2;
		return memo[smaller];
	}
}
