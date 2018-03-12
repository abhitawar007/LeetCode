package testing;

import algorithms.GraphAlgos;

public class GraphTesting
{
	public static void main(String[] args)
	{
		GraphAlgos graph = new GraphAlgos();

		// course schedule
		int[][] prereqs = { { 1, 0 }, { 2, 0 }, { 1, 1 } };
		System.out.println(graph.courseSchedule(3, prereqs));
	}
}
