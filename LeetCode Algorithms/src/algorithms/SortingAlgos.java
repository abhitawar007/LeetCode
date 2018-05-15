package algorithms;

public class SortingAlgos
{
	public void insertionSort(int[] nums)
	{
		/*
		 * Normal insertion sort algorithm
		 */

		int n = nums.length;
		if (n <= 1)
			return;

		for (int i = 1; i < n; i++)
		{
			int curr = nums[i];
			int j = i - 1;
			while (j >= 0)
			{
				if (nums[j] > curr)
				{
					nums[j + 1] = nums[j];
					j--;
				}
				else
					break;
			}
			nums[j + 1] = curr;
		}
	}

	public void binarySort(int[] nums)
	{
		/*
		 * Similar to insertion sort but use Binary Search to find insertion location
		 */

		int n = nums.length;
		if (n <= 1)
			return;

		for (int i = 0; i < n; i++)
		{
			int curr = nums[i];
			int hi = i - 1;
			int index = binarySearch(nums, 0, hi, curr);

			while (hi >= index)
			{
				nums[hi + 1] = nums[hi];
				hi--;
			}
			nums[index] = curr;
		}
	}

	private int binarySearch(int[] nums, int lo, int hi, int target)
	{
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] < target)
				lo = mid + 1;
			else if (nums[mid] > target)
				hi = mid - 1;
		}
		return lo;
	}

}
