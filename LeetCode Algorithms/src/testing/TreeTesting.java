package testing;

import algorithms.TreeAlgos;
import algorithms.TreeNode;

public class TreeTesting
{

	public static void main(String[] args)
	{
		TreeAlgos tree = new TreeAlgos();
		TreeNode p = null, q = null;
		// int[] arr = { 1, 2, 3, 4, 5 };
		// int[] arr = { -10, -5, 0, 5 };
		// TreeNode root = tree.createBSTfromArray(arr);
		// tree.printTree(root);

		// level order list creation
		TreeNode root = new TreeNode(0);
		TreeNode dummy = root;

		root.left = new TreeNode(1);
		root.right = new TreeNode(1);

		// root = root.left;
		// p = root;
		//
		// root.left = new TreeNode(11);
		// root = root.left;
		//
		// root.left = new TreeNode(7);
		// root.right = new TreeNode(2);
		//
		// root = dummy.right;
		//
		// root.left = new TreeNode(13);
		// root.right = new TreeNode(4);
		//
		// root = root.right;
		//
		// root.left = new TreeNode(5);
		// root.right = new TreeNode(1);
		//
		// q = root.left;
		// System.out.println(tree.commonAncestor(dummy, p, q).val);

		System.out.println("Number of paths with given sum : " + tree.pathSum(dummy, 1));

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
