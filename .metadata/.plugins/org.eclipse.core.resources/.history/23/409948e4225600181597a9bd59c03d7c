package algorithms;

import java.util.HashMap;
import java.util.Iterator;

public class GraphAlgos
{

	public boolean courseSchedule(int numOfCourses, int[][] prerequisites)
	{
		// Leetcode: 207. Course Schedule
		int n = prerequisites.length;
		if (n == 0 || n == 1)
			return true;

		HashMap<Integer, GraphNode> map = new HashMap<>();

		// Create graph
		for (int i = 0; i < n; i++)
		{
			GraphNode first, second;

			map.put(prerequisites[i][0],
					map.getOrDefault(prerequisites[i][0], new GraphNode(prerequisites[i][0])));
			map.put(prerequisites[i][1],
					map.getOrDefault(prerequisites[i][1], new GraphNode(prerequisites[i][1])));
			first = map.get(prerequisites[i][0]);
			second = map.get(prerequisites[i][1]);

			first.outgoing.add(second);
			second.incoming.add(first);
		}

		// Logic
		while (!map.isEmpty())
		{
			boolean isCycle = true;
			Iterator<Integer> it = map.keySet().iterator();

			while (it.hasNext())
			{
				int i = it.next();
				GraphNode node = map.get(i);
				if (node.incoming.size() == 0)
				{
					isCycle = false;

					for (GraphNode temp : node.outgoing)
						temp.incoming.remove(node);
					it.remove();
				}
			}
			if (isCycle)
				return false;
		}
		return true;

	}

}
