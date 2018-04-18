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
		TreeNode root = new TreeNode(5);
		TreeNode dummy = root;

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root = root.right;
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root = root.left;
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);

		// ___________________________________________________
		// Serialize - Deserialize
		System.out.println("__________ BEFORE ______________");
		tree.printTree(dummy);
		TreeNode ans = tree.deserialize(tree.serialize(dummy));
		System.out.println("__________ AFTER ______________");
		tree.printTree(ans);

		// ___________________________________________________

		// ___________________________________________________
		// UniValue
		// tree.printTree(dummy);
		// System.out.println("Longest univalue path : " +
		// tree.longestUnivaluePath(dummy));
		// ___________________________________________________

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

		// System.out.println("Number of paths with given sum : " + tree.pathSum(dummy,
		// 1));

		// int[] preorder = { 3, 9, 20, 15, 7 };
		// int[] inorder = { 9, 3, 15, 20, 7 };
		// tree.printTree(tree.buildTree(preorder, inorder));

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
