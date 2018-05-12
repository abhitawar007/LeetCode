package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill)
	{
		// 582. Kill Process

		List<Integer> list = new ArrayList<Integer>();
		if (pid.size() == 0)
			return list;

		HashMap<Integer, GraphNode> map = new HashMap<Integer, GraphNode>();

		// Create graph
		for (int i = 0; i < pid.size(); i++)
		{
			int pidKey = pid.get(i);
			int ppidKey = ppid.get(i);

			if (!map.containsKey(pidKey))
				map.put(pidKey, new GraphNode(pidKey));
			if (!map.containsKey(ppidKey))
				map.put(ppidKey, new GraphNode(ppidKey));

			map.get(pidKey).parent = map.get(ppidKey); // Set parent
			map.get(ppidKey).outgoing.add(map.get(pidKey)); // Add child to parent
		} // Graph is created

		// Check if the kill key really exists
		if (!map.containsKey(kill))
			return list;

		// List down all the processes that are going to get killed
		dfs(map.get(kill), list);

		return list;
	}

	private void dfs(GraphNode root, List<Integer> list)
	{
		if (root == null)
			return;

		list.add(root.value);
		for (GraphNode node : root.outgoing)
			dfs(node, list);
	}

}
