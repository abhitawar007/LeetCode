package testing;

import algorithms.TreeAlgos;
import algorithms.TreeNode;

public class TreeTesting
{

	public static void main(String[] args)
	{
		TreeAlgos tree = new TreeAlgos();
		// int[] arr = { 1, 2, 3, 4, 5 };
		// int[] arr = { -10, -5, 0, 5 };
		// TreeNode root = tree.createBSTfromArray(arr);
		// tree.printTree(root);

		// level order list creation
		TreeNode root = new TreeNode(3);
		TreeNode dummy = root;
		root.left = new TreeNode(9);
		TreeNode p = root.left;
		root.right = new TreeNode(20);
		root = root.right;
		root.left = new TreeNode(15);
		root.right = new TreeNode(7);
		root = root.left;
		root.left = new TreeNode(10);

		TreeNode q = root.left;
		System.out.println(tree.commonAncestor(dummy, p, q).val);

		// System.out.println(tree.isBalanced(dummy));

		// List<List<Integer>> list = tree.levelOrder(dummy);
		// for (List<Integer> lst : list)
		// {
		// for (Integer i : lst)
		// System.out.print(i + " ");
		// System.out.println();
		// }

	}

}
