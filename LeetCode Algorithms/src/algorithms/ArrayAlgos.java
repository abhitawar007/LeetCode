package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class ArrayAlgos
{
	class MyComparator implements Comparator<Integer>
	{
		@Override
		public int compare(Integer arg0, Integer arg1)
		{
			// TODO Auto-generated method stub
			if (arg0.intValue() < arg1.intValue())
				return -1;
			else if (arg0.intValue() > arg1.intValue())
				return 1;
			return 0;
		}
	}

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

	public List<String> topKFrequent(String[] words, int k)
	{
		// 692. Top K Frequent Words
		List<String> list = new ArrayList<>();

		int n = words.length;
		if (n == 0)
			return list;

		HashMap<String, Integer> map = new HashMap<>();
		int max = 0;

		for (String s : words)
		{
			if (!map.containsKey(s))
				map.put(s, 0);

			map.put(s, map.get(s) + 1);
			max = Math.max(max, map.get(s));
		}

		System.out.println(map);

		List<List<String>> alist = new ArrayList<List<String>>();
		for (int i = 0; i <= max + 1; i++)
			alist.add(i, null);

		for (String s : map.keySet())
		{
			int val = map.get(s);
			System.out.println("val : " + val);

			if (alist.get(val) == null)
				alist.set(val, new ArrayList<String>());

			alist.get(val).add(s);
		}

		System.out.println("List _____ " + alist);

		while (k > 0)
		{
			for (int i = max; i >= 0; i--)
			{
				System.out.println("i : " + i);
				List<String> al = alist.get(i);
				if (al == null)
					continue;
				Collections.sort(al);
				for (String s : al)
				{
					if (k-- > 0)
						list.add(s);
					else
						return list;
				}
			}
		}

		return list;
	}

	public int findKthLargest(int[] nums, int k)
	{
		int n = nums.length;
		if (n == 0)
			return 0;

		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new MyComparator());

		for (int i = 0; i < n; i++)
			q.offer(i);

		int ans = 0;
		for (int i = 0; i < k; i++)
			ans = q.poll();

		return ans;

	}

	public int findDuplicate(int[] nums)
	{
		// 287. Find the Duplicate Number

		int n = nums.length;
		if (n == 0)
			return 0;

		int start = 1, end = n, hi = 0, lo = 0;

		while (start < end)
		{
			int mid = start + (end - start) / 2;
			boolean gotMid = false;
			lo = 0;
			hi = 0;
			for (int i = 0; i < n; i++)
			{
				int curr = nums[i];
				if (curr < mid)
					lo++;
				else if (curr > mid)
					hi++;
				else if (!gotMid)
					gotMid = true;
				else
					return mid;
			}

			if (lo >= mid)
				end = mid;
			else
				start = mid;
		}
		return start;
	}

	public void rotate(int[] nums, int k)
	{
		// 189. Rotate Array

		int n = nums.length;
		if (n <= 1)
			return;
		reverseArray(nums, 0, k);
		System.out.println("First reverse");
		print(nums);
		reverseArray(nums, k + 1, n - 1);
		System.out.println("second reverse");
		print(nums);
		reverseArray(nums, 0, n - 1);
	}

	private void reverseArray(int[] nums, int lo, int hi)
	{
		int mid = lo + (hi - lo) / 2;

		for (int i = lo; i <= mid; i++)
		{
			int temp = nums[i];
			nums[i] = nums[hi + lo - i];
			nums[hi + lo - i] = temp;
		}
	}

	public void print(int[] nums)
	{
		System.out.println();
		int n = nums.length;
		for (int i = 0; i < n; i++)
			System.out.print(nums[i] + " ");
	}

	public int nextGreaterElement(int n)
	{
		// 556. Next Greater Element III

		if (n <= 9)
			return -1;

		List<Integer> list = new ArrayList<Integer>();

		for (int i = n; i > 0; i /= 10)
			list.add(0, i % 10);

		int k = -1;

		for (int i = list.size() - 2; i >= 0; i--)
		{
			if (list.get(i) < list.get(i + 1))
			{
				k = i;
				break;
			}
		}

		if (k == -1)
			return -1;

		swap(list, k);
		reverse(list, k + 1);

		int ans = 0;
		for (int i = 0; i < list.size(); i++)
			ans = ans * 10 + list.get(i);

		return ans < 0 || ans < n ? -1 : ans;
	}

	private void swap(List<Integer> list, int k)
	{
		for (int l = list.size() - 1; l > k; l--)
		{
			if (list.get(l) > list.get(k))
			{
				int temp = list.get(l);
				list.set(l, list.get(k));
				list.set(k, temp);

				break;
			}
		}
	}

	private void reverse(List<Integer> list, int k)
	{
		int lo = k, hi = list.size() - 1;

		while (lo < hi)
		{
			int temp = list.get(lo);
			list.set(lo, list.get(hi));
			list.set(hi, temp);
			lo++;
			hi--;
		}
	}

}
