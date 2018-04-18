package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayAlgos
{
	public int removeElement(int[] arr, int val)
	{
		// 27. Remove Element. Return the new length. Don't care about order and what is
		// behind length
		int n = arr.length;
		if (n == 0)
			return n;

		int j = n - 1, i = 0;

		while (i <= j)
		{
			while (j >= 0 && arr[j] == val)
				j--;
			if (j == 0 || i >= j)
				return j + 1;
			if (arr[i] == val)
			{
				arr[i] = arr[j];
				arr[j] = val;
				j--;
			}
			i++;
		}
		return j + 1;

		//////////////////// or /////////////////
		// int id = 0, n = arr.length;
		// for(int i=0; i<n; i++)
		// {
		// if(arr[i] != val)
		// arr[id++] = arr[i];
		// }
		// return id;
	}

	public int findMinRot(int[] nums)
	{
		// 153. Find Minimum in Rotated Sorted Array

		if (nums.length == 0)
			return 0;

		int lo = 0, hi = nums.length - 1, mid = 0;

		while (lo < hi)
		{
			mid = (lo + hi) / 2;
			if (nums[mid] > nums[hi])
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

	public int searchRot(int[] nums, int target)
	{
		// 33. Search in Rotated Sorted Array
		int n = nums.length;
		if (n == 0)
			return -1;

		int pivot = findMinRot(nums);

		if (nums[pivot] == target)
			return pivot;
		if (pivot == 0)
			return binarySearch(nums, 0, n - 1, target);
		if (nums[0] <= target)
			return binarySearch(nums, 0, pivot - 1, target);
		return binarySearch(nums, pivot + 1, n - 1, target);

	}

	public int binarySearch(int[] nums, int lo, int hi, int target)
	{
		if (nums.length == 0)
			return -1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return -1;
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	{
		// 733. Flood Fill
		int rows = image.length;
		if (image.length == 0 || image[sr][sc] == newColor)
			return image;
		int cols = image[0].length;
		int oldColor = image[sr][sc];

		// DFS
		Stack<int[]> s = new Stack<>();
		image[sr][sc] = newColor;

		int[] tempArr = { sr, sc };
		s.push(tempArr);

		while (!s.isEmpty())
		{
			int[] arr = s.pop();
			List<int[]> list = getAdjecent(arr, image, rows, cols, oldColor);
			for (int[] a : list)
			{
				image[a[0]][a[1]] = newColor;
				s.push(a);
			}
		}
		return image;
	}

	private List<int[]> getAdjecent(int[] arr, int[][] image, int rows, int cols, int oldColor)
	{

		// Helper function of floodFill
		int row = arr[0];
		int col = arr[1];
		List<int[]> list = new ArrayList<>();

		if (row > 0 && image[row - 1][col] == oldColor)
		{
			int[] tempArr = { row - 1, col };
			list.add(tempArr);
		}
		if (row < rows - 1 && image[row + 1][col] == oldColor)
		{
			int[] tempArr = { row + 1, col };
			list.add(tempArr);
		}
		if (col > 0 && image[row][col - 1] == oldColor)
		{
			int[] tempArr = { row, col - 1 };
			list.add(tempArr);
		}
		if (col < cols - 1 && image[row][col + 1] == oldColor)
		{
			int[] tempArr = { row, col + 1 };
			list.add(tempArr);
		}

		return list;

	}

	public List<Integer> countSmaller(int[] nums)
	{
		// 315. Count of Smaller Numbers After Self

		List<Integer> list = new ArrayList<>();

		int n = nums.length;

		if (n == 0)
			return list;

		TreeNode root = null;

		for (int i = n - 1; i >= 0; i--)
		{
			int currInt = nums[i];
			if (root == null)
			{
				root = new TreeNode(currInt, 0);
				list.add(0, 0);
				continue;
			}

			TreeNode curr = root, prev = root;
			int temp = 0;

			while (curr != null)
			{
				prev = curr;
				if (currInt <= curr.val)
				{
					temp = curr.leftTempVal;
					curr.rightTempVal++;
					curr = curr.left;
				}
				else
				{
					curr = curr.right;
					temp = prev.rightTempVal + 1;
				}
			}

			list.add(0, temp);
			if (currInt <= prev.val)
				prev.left = new TreeNode(currInt, temp);
			else
				prev.right = new TreeNode(currInt, temp);
		}

		return list;

	}

}
