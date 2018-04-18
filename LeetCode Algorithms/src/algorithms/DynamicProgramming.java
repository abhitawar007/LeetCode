package algorithms;

import java.util.Arrays;

public class DynamicProgramming
{
	public int fibonacci(int n)
	{
		// Recursive working
		// if (n == 0 || n == 1)
		// return n;
		// return fibonacci(n - 1) + fibonacci(n - 2);

		// _________DP____________
		int[] arr = new int[n];

		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < n; i++)
			arr[i] = arr[i - 1] + arr[i - 2];

		return arr[n - 1] + arr[n - 2];
	}

	public int climbStairs(int n)
	{
		// 70. Climbing Stairs
		// Each time you can either climb 1 or 2 steps. In how many distinct ways can
		// you climb to the top?

		// Recursive
		int[] arr = new int[n + 1];
		return climbStairs(n, arr);

		// iterative
		// if (n < 1)
		// return 0;
		// if (n == 1)
		// return 1;
		// if (n == 2)
		// return 2;
		//
		// int one_step = 1;
		// int two_step = 2;
		// int all_ways = 0;
		//
		// for(int i=3; i<=n ; i++)
		// {
		// all_ways = one_step + two_step;
		// one_step = two_step;
		// two_step = all_ways;
		// }
		// return all_ways;
	}

	private int climbStairs(int n, int[] arr)
	{
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		if (arr[n] == 0)
			arr[n] = climbStairs(n - 1) + climbStairs(n - 2);
		return arr[n];
	}

	public int minCostClimbingStairs(int[] cost)
	{
		int n = cost.length;

		// Recursive
		int[] arr = new int[n];
		return (Math.min(cost(n - 1, cost, arr), cost(n - 2, cost, arr)));

		// Iterative
		// int dp0 = 0;
		// int dp1 = 0;
		// int dp2 = 0;
		//
		// for (int i = 2; i < n+1; i++){
		// dp2 = Math.min(dp0 + cost[i-2], dp1 + cost[i-1]);
		// dp0 = dp1;
		// dp1 = dp2;
		// }
		// return dp2;
	}

	public int cost(int n, int[] cost, int[] arr)
	{
		if (n < 0)
			return 0;
		if (arr[n] == 0)
			arr[n] = cost[n] + Math.min(cost(n - 1, cost, arr), cost(n - 2, cost, arr));
		return arr[n];
	}

	public int coinChange(int[] coins, int amount)
	{
		if (amount == 0)
			return 0;
		if (coins.length == 0)
			return -1;
		Arrays.sort(coins);
		return helper(coins, coins.length - 1, amount);
	}

	private int helper(int[] coins, int coin, int val)
	{
		if (coin < 0)
			return -1;

		if (val == coins[coin])
			return 1;
		int mul = val / coins[coin];

		int ans = (val % coins[coin] == 0) ? mul : Integer.MAX_VALUE;

		while (mul >= 0)
		{
			// int passVal = mul == 0 ? val : val - mul
			int ret = helper(coins, coin - 1, val - mul * coins[coin]);
			if (ret != -1)
			{
				ans = Math.min(ans, mul + ret);
			}
			mul--;
		}

		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}
