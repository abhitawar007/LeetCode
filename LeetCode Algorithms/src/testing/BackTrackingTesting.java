package testing;

import algorithms.BackTracking;

public class BackTrackingTesting
{
	public static void main(String[] args)
	{
		BackTracking bk = new BackTracking();

		// __________________________________________________________________
		// N Queens
		System.out.println(bk.solveNQueens(4));
		// __________________________________________________________________
	}
}