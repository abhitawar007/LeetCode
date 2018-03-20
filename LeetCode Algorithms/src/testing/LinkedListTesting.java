package testing;

import algorithms.LinkedListAlgos;
import algorithms.ListNode;

public class LinkedListTesting
{

	public static void main(String[] args)
	{
		// Linked list palindrome
		// Generate Linked list
		ListNode h1 = new ListNode(1);
		ListNode c1 = h1;

		c1.next = new ListNode(2);
		c1 = c1.next;
		c1.next = new ListNode(5);
		c1 = c1.next;
		c1.next = new ListNode(7);
		c1 = c1.next;
		c1.next = new ListNode(10);
		c1 = c1.next;
		c1.next = new ListNode(15);
		c1 = c1.next;
		c1.next = new ListNode(70);

		// c3 = c1;
		// c1.next = c3;

		ListNode h2 = new ListNode(3);
		ListNode c2 = h2;
		// c2.next = new ListNode(6);
		// c2 = c2.next;
		// c2.next = new ListNode(8);

		ListNode h3 = new ListNode(2);
		ListNode c3 = h3;

		c3.next = new ListNode(4);
		c3 = c3.next;
		c3.next = new ListNode(9);
		c3 = c3.next;
		c3.next = new ListNode(11);
		c3 = c3.next;
		c3.next = new ListNode(14);
		c3 = c3.next;
		c3.next = new ListNode(15);

		// c2.next = c3;
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
		// ___________________________________________________________________________
		// ListNode ans = lla.hasCycle(h1);
		// if (ans == null)
		// System.out.println("null");
		// else
		// System.out.println("Cycle starts at : " + ans.val);
		// ___________________________________________________________________________
		// HashMap<Character, Integer> map = new HashMap<>();
		// map.put('a', map.getOrDefault('a', 1) + 1);
		// System.out.println(map);
		// ___________________________________________________________________________
		// reverseKGroup

		// lla.printList(lla.reverseKGroup(h1, 1));
		// ___________________________________________________________________________

		// merge k lists
		ListNode[] lists = { h1, h2, h3, null };
		lla.printList(lla.mergeKLists(lists));

	}

}
