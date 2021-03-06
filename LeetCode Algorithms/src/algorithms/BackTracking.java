package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BackTracking
{
	public List<List<Integer>> solveNQueens(int n)
	{
		// CTCI
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (n == 0)
			return list;
		List<Integer> tempList = new ArrayList<>();
		placeQueen(0, tempList, list, n);
		return list;
	}

	private void placeQueen(int row, List<Integer> tempList, List<List<Integer>> list, int n)
	{
		if (tempList.size() == n)
		{
			list.add(new ArrayList<Integer>(tempList));
			return;
		}

		for (int col = 0; col < n; col++)
		{
			if (checkValidPlacement(tempList, row, col))
			{
				tempList.add(col);
				placeQueen(row + 1, tempList, list, n);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	private boolean checkValidPlacement(List<Integer> tempList, int row, int col)
	{
		for (int row2 = 0; row2 < tempList.size(); row2++)
		{
			int col2 = tempList.get(row2);

			// If columns match, return false
			if (col == col2)
				return false;

			// If distance between columns is same as distance between rows, it means a
			// diagonal element
			int colDist = Math.abs(col2 - col);

			// No need of abs for row dist as row2 < row always
			int rowDist = row - row2;
			if (rowDist == colDist)
				return false;
		}
		return true;
	}
}
