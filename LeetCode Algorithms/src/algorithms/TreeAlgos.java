package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeAlgos
{
	public void printTree(TreeNode root)
	{
		if (root == null)
			return;
		print(root, 0);
	}

	private void print(TreeNode root, int spaces)
	{
		if (root == null)
			return;

		print(root.right, spaces + 4);
		String blank = "";
		for (int i = 0; i < spaces; i++)
			blank += " ";
		System.out.println(blank + root.value);

		print(root.left, spaces + 4);
	}

	public TreeNode createBSTfromArray(int[] arr)
	{
		if (arr.length == 0)
			return null;
		if (arr.length == 1)
			return new TreeNode(arr[0]);

		return createBST(arr, 0, arr.length - 1);
	}

	private TreeNode createBST(int[] arr, int lo, int hi)
	{
		if (lo > hi)
			return null;

		int mid = ((lo + hi) / 2);
		TreeNode node = new TreeNode(arr[mid]);

		if (lo == hi)
			return node;

		node.left = createBST(arr, lo, mid - 1);
		node.right = createBST(arr, mid + 1, hi);

		return node;
	}

	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		list.add(new ArrayList<Integer>());

		TreeNode prev = null;

		while (!q.isEmpty())
		{
			TreeNode node = q.remove();
			if (node == null)
			{
				if (prev == null)
					list.remove(list.size() - 1);
				else
				{
					q.add(null);
					list.add(new ArrayList<Integer>());
				}
			}
			else
			{
				list.get(list.size() - 1).add(node.value);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			prev = node;
		}

		return list;

	}

	public int height(TreeNode root)
	{
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public boolean isBalanced(TreeNode root)
	{
		// determine if the tree is height-balanced.
		if (root == null)
			return true;

		if (Math.abs(height(root.left) - height(root.right)) > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);

	}

	public boolean isValidBST(TreeNode root)
	{
		if (root == null)
			return true;

		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBST(TreeNode root, int min, int max)
	{
		if (root == null)
			return true;
		int i = root.value;
		if (i < min || i > max)
			return false;

		return (isBST(root.left, min, i - 1) && isBST(root.right, i + 1, max));
	}
}
