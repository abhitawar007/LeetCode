package algorithms;
import java.util.*;

public class TaskScheduler 
{
	public int leastInterval(char[] tasks, int n) 
	{
		// Initialization
		int t = tasks.length;
		int[] store = new int[26];

		// Base condition
		if(t <= 1 || n==0)
			return t;

		for(int i=0; i<t; i++)
			store[tasks[i] - 'A']++;

		Arrays.sort(store);

		List<Integer> list = new ArrayList<>();

		for(int i=0; i<=n; i++)
			list.add(-1);
		
		int count = 0;
		boolean flag = false;

		while(t > 0)
		{
			list.remove(0);
			flag = false;
			for(int i=25; i>=0; i--)
			{
				if(store[i] == 0 || list.contains(i))
					continue;
				else
				{
					list.add(i);
					store[i]--;
					count--;
					t--;
					flag = true;
					break;
				}
			}
			count++;
			if(!flag)
				list.add(-1);
		}

		return count + tasks.length;
	}
}
