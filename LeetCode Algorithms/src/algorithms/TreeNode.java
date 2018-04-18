package algorithms;

public class TreeNode
{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public int leftTempVal;
	public int rightTempVal;

	public TreeNode(int _val)
	{
		val = _val;
		left = null;
		right = null;
	}

	public TreeNode(int _val, int _tempVal)
	{
		val = _val;
		left = null;
		right = null;
		leftTempVal = _tempVal;
	}
}
