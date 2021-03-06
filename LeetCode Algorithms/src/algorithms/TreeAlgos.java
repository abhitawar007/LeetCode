package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeAlgos
{

	private int ctr = 0;

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
		System.out.println(blank + root.val);

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
				list.get(list.size() - 1).add(node.val);
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
		if (checkBalanced(root) != Integer.MIN_VALUE)
			return true;
		else
			return false;

	}

	private int checkBalanced(TreeNode root)
	{
		if (root == null)
			return -1;

		// Check left subTree
		int left = checkBalanced(root.left);
		if (left == Integer.MIN_VALUE) // Check for error
			return Integer.MIN_VALUE;

		// Check right subTree
		int right = checkBalanced(root.right);
		if (right == Integer.MIN_VALUE) // Check for error
			return Integer.MIN_VALUE;

		if (Math.abs(left - right) > 1)
			return Integer.MIN_VALUE; // Create error

		return Math.max(left, right) + 1; // Return self height
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
		int i = root.val;
		if (i < min || i > max)
			return false;

		return (isBST(root.left, min, i - 1) && isBST(root.right, i + 1, max));
	}

	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
		// in the tree.

		// Check if tree contains both p and q
		if (!treeContains(root, p) || !treeContains(root, q))
			return null;
		return findAncestor(root, p, q);

	}

	public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		if (root == null)
			return null;

		if (root == p || root == q)
			return root;

		TreeNode leftRoot = findAncestor(root.left, p, q);
		TreeNode rightRoot = findAncestor(root.right, p, q);

		if (leftRoot != null && rightRoot != null)
			return root;

		return leftRoot != null ? leftRoot : rightRoot;
	}

	public boolean treeContains(TreeNode root, TreeNode x)
	{
		if (root == null)
			return false;
		if (root == x)
			return true;
		return (treeContains(root.left, x) || treeContains(root.right, x));
	}

	public boolean isSubtree(TreeNode t1, TreeNode t2)
	{
		// 572. Subtree of Another Tree
		if (t2 == null)
			return true;

		if (traverse(t1, t2))
			return true;
		return false;
	}

	public boolean traverse(TreeNode t1, TreeNode t2)
	{
		if (t1 == null)
			return false;
		if (t1.val == t2.val)
			if (isBinarySubTree(t1, t2))
				return true;
		return traverse(t1.left, t2) || traverse(t1.right, t2);
	}

	public boolean isBinarySubTree(TreeNode t1, TreeNode t2)
	{
		if (t1 == null && t2 == null)
			return true;

		if (t1 == null && t2 != null)
			return false;

		if (t1 != null && t2 == null)
			return false;

		if (t1.val != t2.val)
			return false;

		return isBinarySubTree(t1.left, t2.left) && isBinarySubTree(t1.right, t2.right);
	}

	public boolean hasPathSum(TreeNode root, int sum)
	{
		// 112. Path Sum: Given a binary tree and a sum, determine if the tree has a
		// root-to-leaf path such that adding up all the values along the path equals
		// the given sum.
		if (root == null)
			return false;

		int subsum = sum - root.val;
		if (subsum == 0)
			if (root.left == null && root.right == null)
				return true;
		return hasPathSum(root.left, subsum) || hasPathSum(root.right, subsum);
	}

	public int pathSum(TreeNode root, int sum)
	{
		// 437. Path Sum III || also: CTCI
		printTree(root);

		if (root == null)
			return ctr;
		List<Integer> list = new ArrayList<>();
		list.add(sum);
		// list.add(sum-root.val);
		helperforPathSum(root, list, sum);
		return ctr;
	}

	public void helperforPathSum(TreeNode root, List<Integer> list, int sum)
	{
		if (root == null)
			return;
		for (int i : list)
			if (i == root.val)
				ctr++;
		List<Integer> temp = new ArrayList<>();
		temp.add(sum);
		for (int i : list)
		{
			int tempVal = i - root.val;
			// if (!list.contains(tempVal) && !temp.contains(tempVal))
			temp.add(i - root.val);
		}

		// if (list.size() > 1 && root.left == null && root.right == null && list.get(0)
		// == root.val)
		// ctr++;

		// List<Integer> sendList = new ArrayList<>();

		// sendList.addAll(list);
		// sendList.addAll(temp);
		helperforPathSum(root.left, temp, sum);
		helperforPathSum(root.right, temp, sum);
	}

	public List<List<Integer>> pathSum2(TreeNode root, int sum)
	{
		// 113. Path Sum 2: Return all the paths from root to leaf which add up to sum
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;

		List<Integer> passList = new ArrayList<>();

		findPath(root, passList, sum, list);
		return list;
	}

	public void findPath(TreeNode root, List<Integer> passList, int sum, List<List<Integer>> list)
	{
		if (root == null)
			return;
		int rootval = root.val;
		passList.add(rootval);

		if (root.left == null && root.right == null)
		{
			if (rootval == sum)
				list.add(new ArrayList<>(passList));
		}
		else
		{
			findPath(root.left, passList, sum - rootval, list);
			findPath(root.right, passList, sum - rootval, list);
		}

		passList.remove(passList.size() - 1);
	}

	int p = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		// 105: Construct Binary Tree from Preorder and Inorder Traversal
		if (preorder.length == 0)
			return null;

		return buildTree(preorder, inorder, 0, inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int inS, int inE)
	{
		if (inE < inS)
			return null;

		int index = findIndex(preorder[p], inorder, inS, inE);
		TreeNode node = new TreeNode(preorder[p++]);

		node.left = buildTree(preorder, inorder, inS, index - 1);
		node.right = buildTree(preorder, inorder, index + 1, inE);

		return node;
	}

	public int findIndex(int x, int[] inorder, int inS, int inE)
	{
		int lo = inS, hi = inE;
		for (int i = inS; i <= inE; i++)
			if (x == inorder[i])
				return i;
		return -1;
		// while (lo <= hi)
		// {
		// int mid = (lo + hi) / 2;
		// int midval = inorder[mid];
		// if (midval == x)
		// return mid;
		// else if (midval > x)
		// hi = mid;
		// else
		// lo = mid + 1;
		// }
		// return -1;
	}

	int max = 0;

	public int longestUnivaluePath(TreeNode root)
	{
		if (root == null)
			return 0;
		pathHelper(root, 0, 0);
		return max;
	}

	private int pathHelper(TreeNode root, int parentVal, int ctr)
	{
		if (root == null)
			return 0;
		int temp = 0;
		if (root.val == parentVal)
			temp = ctr + 1;
		int leftVal = pathHelper(root.left, root.val, temp);
		int rightVal = pathHelper(root.right, root.val, temp);

		max = Math.max(max, leftVal + rightVal);

		return root.val == parentVal ? temp : 0;
	}

	int itr;

	// Encodes a tree to a single string.
	public String serialize(TreeNode root)
	{
		StringBuilder sb = new StringBuilder();

		preorder(root, sb);
		// System.out.println(sb.toString());
		return sb.toString();
	}

	private void preorder(TreeNode root, StringBuilder sb)
	{
		if (root == null)
		{
			sb.append("null,");
			return;
		}

		sb.append(root.val);
		sb.append(",");
		preorder(root.left, sb);
		preorder(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data)
	{
		if (data.length() == 0)
			return null;

		String[] arr = data.split(",");
		itr = 0;
		return build(arr);
	}

	private TreeNode build(String[] arr)
	{
		// System.out.println(arr[i]);
		if (itr >= arr.length)
			return null;

		if (arr[itr].equals("null"))
		{
			itr++;
			return null;
		}

		TreeNode node = new TreeNode(Integer.parseInt(arr[itr++]));
		node.left = build(arr);
		node.right = build(arr);

		return node;
	}

	public int numTrees(int n)
	{
		// 96. Unique Binary Search Trees

		if (n <= 1)
			return n;

		return numTrees(1, n, n);
	}

	private int numTrees(int lo, int hi, int n)
	{
		if (lo < 1 || hi > n || lo > hi)
			return 1;
		if (lo == hi)
			return 1;

		int ans = 0;
		for (int i = lo; i <= hi; i++)
		{
			int leftans = numTrees(lo, i - 1, n);
			int rightans = numTrees(i + 1, hi, n);
			ans += Math.max(leftans, rightans);
		}

		return ans;
	}

}
