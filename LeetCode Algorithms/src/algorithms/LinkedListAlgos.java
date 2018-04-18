package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LinkedListAlgos
{
	public ListNode intersection(ListNode l1, ListNode l2)
	{
		/*
		 * Return the first common node of two LLs if LLs don't intersect, return new
		 * node with value -1
		 */

		if (l1 == null || l2 == null)
			return null;
		System.out.println("Initial Lists");
		printList(l1);
		printList(l2);

		int len1 = 0, len2 = 0;

		ListNode curr1 = l1, curr2 = l2;

		while (curr1 != null)
		{
			len1++;
			curr1 = curr1.next;
		}

		while (curr2 != null)
		{
			len2++;
			curr2 = curr2.next;
		}

		if (len1 > len2)
			while (len1-- != len2)
				l1 = l1.next;
		else
			while (len2-- != len1)
				l2 = l2.next;

		while (l1.label != l2.label)
		{
			l1 = l1.next;
			l2 = l2.next;

			if (l1 == null || l2 == null)
				return new ListNode(-1);
		}

		return l1;
	}

	public boolean isPalindrome(ListNode head)
	{
		// Check if the Linked list is a palindrome

		if (head == null || head.next == null)
			return true;

		ListNode slow = head, fast = head;
		Stack<Integer> s = new Stack<>();

		while (fast != null && fast.next != null)
		{
			s.push(slow.label);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) // odd length
			slow = slow.next;

		while (slow != null)
		{
			if (slow.label != s.pop())
				return false;
			slow = slow.next;
		}

		return s.size() == 0;
	}

	public void reverseList(ListNode head)
	{
		// Reverse the complete Linked List

		if (head == null || head.next == null)
			return;

		ListNode prev = null, curr = head, n = null;

		System.out.println("Initial list----------------------");
		printList(head);
		while (curr != null)
		{
			n = curr.next;
			curr.next = prev;
			prev = curr;
			curr = n;
		}

		System.out.println("Final list-------------------------");
		printList(prev);
	}

	public ListNode reverseMtoN(ListNode head, int m, int n)
	{
		// Reverse the Linked List from position m to position n

		if (head == null || head.next == null)
			return head;

		System.out.println("m = " + m + " _______ n = " + n + " ___________");
		printList(head);
		try
		{

			ListNode prev = new ListNode(0);
			ListNode curr = head;
			prev.next = head;

			for (int i = 1; i < m; i++)
			{
				if (curr == null)
					throw new Exception("m is out of range!");
				prev = curr;
				curr = curr.next;
			}

			ListNode dummy = prev, dummy1 = curr;
			prev = curr;
			if (curr == null)
				return head;
			curr = curr.next;

			for (int i = m; i < n; i++)
			{
				if (curr == null)
					throw new Exception("n is out of range!");
				ListNode nn = curr.next;
				curr.next = prev;
				prev = curr;
				curr = nn;
			}

			dummy.next = prev;
			dummy1.next = curr;
			if (dummy1 == head)
				head = prev;

			System.out.println("After_________________________");
			printList(head);

			return head;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return head;
		}
	}

	public ListNode hasCycle(ListNode head)
	{
		if (head == null || head.next == null)
			return head;

		// printList(head);

		ListNode slow = head, fast = head;
		boolean isCycle = false;

		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
			{
				isCycle = true;
				break;
			}
		}

		if (!isCycle)
			return null;
		slow = head;
		while (slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public ListNode reverseKGroup(ListNode head, int k)
	{
		// 25. Reverse Nodes in k-Group
		if (head == null || head.next == null || k == 0)
			return head;

		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode dummy = dummyHead;
		ListNode itr = head;

		while (itr != null)
		{
			for (int i = 0; i < k; i++)
			{
				if (itr == null)
					return dummyHead.next;
				itr = itr.next;
			}

			// Out of for loop implies that next block is present in the list
			ListNode nextDummy = dummy.next;
			dummy.next = reverseForKGroup(dummy, nextDummy, itr);
			if (dummyHead.label == -1)
			{
				dummyHead.next = dummy.next;
				dummyHead.label = 0;
			}
			dummy = nextDummy;
		}
		return dummyHead.next;
	}

	public ListNode reverseForKGroup(ListNode prev, ListNode curr, ListNode terminator)
	{
		boolean flag = true;
		while (curr != terminator)
		{
			ListNode n = curr.next;
			if (flag)
			{
				curr.next = terminator;
				flag = false;
			}
			else
				curr.next = prev;
			prev = curr;
			curr = n;
		}
		return prev;
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		// 23. Merge k Sorted Lists
		if (lists.length == 0 || lists.length == 1)
			return lists[0];
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		HashSet<ListNode> set = new HashSet<>();

		while (true)
		{
			ListNode nextNode = new ListNode(Integer.MAX_VALUE);
			boolean flag = true;

			for (ListNode node : lists)
			{
				while (node != null && set.contains(node))
					node = node.next;
				if (node == null)
					continue;

				if (node.label < nextNode.label)
				{
					flag = false;
					nextNode = node;
				}
			}

			if (flag)
				return dummy.next;
			curr.next = new ListNode(nextNode.label);
			curr = curr.next;
			set.add(nextNode);
		}
	}

	public ListNode copyRandomList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;

		HashMap<Integer, ListNode> map = new HashMap<>();
		map.put(null, null);
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		while (head != null)
		{
			if (map.containsKey(head.label))
			{
				curr.next = map.get(head.label);
				curr = curr.next;

				if (head.next != null && !map.containsKey(head.next.label))
					map.put(head.next.label, new ListNode(head.next.label));

				if (head.random != null && !map.containsKey(head.random.label))
					map.put(head.random.label, new ListNode(head.random.label));

				if (head.next != null)
					curr.next = map.get(head.next.label);

				if (head.random != null)
					curr.random = map.get(head.random.label);
			}
			else
			{
				curr.next = new ListNode(head.label);
				curr = curr.next;

				if (head.next != null && !map.containsKey(head.next.label))
					map.put(head.next.label, new ListNode(head.next.label));

				if (head.random != null && !map.containsKey(head.random.label))
					map.put(head.random.label, new ListNode(head.random.label));

				if (head.next != null)
					curr.next = map.get(head.next.label);

				if (head.random != null)
					curr.random = map.get(head.random.label);

				map.put(curr.label, curr);

			}

			head = head.next;
		}

		return dummy.next;
	}

	public void printList(ListNode head)
	{
		if (head == null)
			System.out.println("List is empty");
		System.out.println();
		while (head != null)
		{
			System.out.print(head.label + " ");
			head = head.next;
		}
		System.out.println();
	}
}
