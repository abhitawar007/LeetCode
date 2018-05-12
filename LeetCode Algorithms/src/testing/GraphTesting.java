package testing;

import java.util.ArrayList;
import java.util.List;

import algorithms.GraphAlgos;

public class GraphTesting
{
	public static void main(String[] args)
	{
		GraphAlgos graph = new GraphAlgos();

		// course schedule
		// int[][] prereqs = { { 1, 0 }, { 2, 0 }, { 1, 1 } };
		// System.out.println(graph.courseSchedule(3, prereqs));
		// _____________________________________________________________________

		// Kill process
		List<Integer> pid = new ArrayList<>();
		List<Integer> ppid = new ArrayList<>();

		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);

		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);

		System.out.println(graph.killProcess(pid, ppid, 5));

		// _____________________________________________________________________
	}
}
