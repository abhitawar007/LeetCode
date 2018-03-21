package testing;

import algorithms.DynamicProgramming;

public class DPTesting
{
	public static void main(String[] args)
	{
		DynamicProgramming dp = new DynamicProgramming();

		// _____________________________________________________________
		// Fibonacci
		// System.out.println("Fibonacci : " + dp.fibonacci(7));
		// _____________________________________________________________

		// Climbing stairs
		// System.out.println("Climbing stairs : " + dp.climbStairs(5));

		// _____________________________________________________________
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println("minimum cost : " + dp.minCostClimbingStairs(cost));
	}

}