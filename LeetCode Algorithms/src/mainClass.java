import algorithms.LinkedListAlgos;
import algorithms.ListNode;

public class mainClass
{

	public static void main(String[] args)
	{
		// Task Scheduler
		// char[] arr = {'A','A','A','B','B','B'};
		// char[] arr = {'A','A','A','A','A','A'};

		// TaskScheduler t = new TaskScheduler();
		// System.out.println(t.leastInterval(arr, 2));

		// FirstBadVersion
		// FirstBadVersion f = new FirstBadVersion();
		// System.out.println(f.firstBadVersion(10));

		// Linked list palindrome
		// Generate Linked list
		ListNode h1 = new ListNode(1);
		ListNode c1 = h1;
		ListNode c3 = null;

		c1.next = new ListNode(2);
		c1 = c1.next;
		c1.next = new ListNode(3);
		c1 = c1.next;
		c1.next = new ListNode(4);
		c1 = c1.next;
		c1.next = new ListNode(5);
		c1 = c1.next;
		c1.next = new ListNode(6);
		c1 = c1.next;
		c3 = c1;
		c1.next = c3;

		ListNode h2 = new ListNode(7);
		ListNode c2 = h2;
		c2.next = new ListNode(8);
		c2 = c2.next;
		c2.next = c3;
		// c2.next = new ListNode(2);
		// c2 = c2.next;
		// c2.next = new ListNode(1);
		// c2 = c2.next;

		// list.reverseList(h1);
		// System.out.println("========================");
		// list.reverseList(h2);
		// System.out.println(list.isPalindrome(h1));
		// System.out.println(list.isPalindrome(h2));

		LinkedListAlgos lla = new LinkedListAlgos();
		// c2.next = c3;
		// System.out.println("Intersection point : " + lla.intersection(h1, h2).val);
		ListNode ans = lla.hasCycle(h1);
		if (ans == null)
			System.out.println("null");
		else
			System.out.println("Cycle starts at : " + ans.val);

		// HashMap<Character, Integer> map = new HashMap<>();
		// map.put('a', map.getOrDefault('a', 1) + 1);
		// System.out.println(map);

	}

}
