package algorithms;

import java.util.Stack;

public class MinStack
{
	/** initialize your data structure here. */
	Stack<Integer> mainStack;
	Stack<Integer> minValues;
	int min = Integer.MAX_VALUE;

	public MinStack()
	{
		mainStack = new Stack<Integer>();
		minValues = new Stack<Integer>();
	}

	public void push(int x)
	{
		if (minValues.isEmpty() || x <= minValues.peek().intValue())
			minValues.push(x);
		mainStack.push(x);
	}

	public void pop()
	{
		if (mainStack.isEmpty())
			return;
		if (minValues.peek().intValue() == mainStack.peek().intValue())
			minValues.pop();
		mainStack.pop();
	}

	public int top()
	{
		if (mainStack.isEmpty())
			return -1;
		return mainStack.peek();
	}

	public int getMin()
	{
		if (minValues.isEmpty())
			return Integer.MAX_VALUE;
		return minValues.peek();
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		MinStack minStack = new MinStack();
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);

		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());

	}

}
