package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public List<List<Integer>> permute(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int n = nums.length;
		if (n == 0)
			return list;
		return permute(nums, 0);
		// return list;
	}

	public List<List<Integer>> permute(int[] nums, int n)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (n >= nums.length)
			return list;
		if (n == nums.length - 1)
		{
			List<Integer> temp = new ArrayList<>();
			temp.add(nums[n]);
			list.add(temp);
			return list;
		}

		// Put something in list
		list = permute(nums, n + 1);

		List<List<Integer>> allLists = new ArrayList<List<Integer>>();
		for (List<Integer> lst : list)
		{
			for (int i = 0; i <= lst.size(); i++)
			{
				List<Integer> temp = createList(lst, nums[n], i);
				allLists.add(temp);
			}
		}
		// list.clear();
		// list.addAll(allLists);
		return allLists;
	}

	List<Integer> createList(List<Integer> lst, int val, int index)
	{
		List<Integer> ret = new ArrayList<>();
		ret.addAll(lst);
		ret.add(index, val);
		return ret;
	}

	public List<List<Integer>> permuteUnique(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return list;
		Arrays.sort(nums);
		List<Integer> tempList = new ArrayList<>();
		List<Integer> iters = new ArrayList<>();
		permuteUnique(nums, tempList, iters, list, nums.length);
		return list;

		// List<List<Integer>> list = new ArrayList<List<Integer>>();
		// int n = nums.length;
		// if (n == 0)
		// return list;
		// return permuteUnique(nums, 0);
		// return list;
	}

	public void permuteUnique(int[] nums, List<Integer> tempList, List<Integer> iters,
			List<List<Integer>> list, int n)
	{
		if (tempList.size() == n)
		{
			list.add(new ArrayList<Integer>(tempList));
			return;
		}
		int prev = -1;
		for (int i = 0; i < n; i++)
		{
			if (iters.contains(i))
				continue;
			if (prev == nums[i] && i == n - 1)
			{
				// tempList.remove(tempList.size() - 1);
				iters.remove(new Integer(i));
				return;
			}
			else if (prev == nums[i])
				continue;
			iters.add(i);
			tempList.add(nums[i]);
			permuteUnique(nums, tempList, iters, list, n);
			prev = nums[i];
			iters.remove(new Integer(i));
			tempList.remove(tempList.size() - 1);
		}
	}
}
