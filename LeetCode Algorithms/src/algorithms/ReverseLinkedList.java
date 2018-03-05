package algorithms;

public class ReverseLinkedList
{
	public ListNode reverseMtoN(ListNode head, int m, int n)
	{
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

	public void printList(ListNode head)
	{
		System.out.println();
		while (head != null)
		{
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}
}
