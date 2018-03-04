package algorithms;

import java.util.Stack;

public class LinkedListPalindrome 
{
	public boolean isPalindrome(ListNode head)
	{
		if(head == null || head.next == null)
			return true;
		
		ListNode slow = head, fast = head;
		Stack<Integer> s = new Stack<>();
		
		while(fast != null && fast.next != null)
		{
			s.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) //odd length
			slow = slow.next;
		
		while(slow != null)
		{
			if(slow.val != s.pop())
				return false;
			slow = slow.next;
		}
		
		return s.size() == 0;
	}
	
	public void reverseList(ListNode head) 
    {
        if(head == null || head.next == null)
            return;
        
        ListNode prev = null, curr = head, n = null;
        
        System.out.println("Initial list----------------------");
        print(head);
        while(curr != null)
        {
            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        
        System.out.println("Final list-------------------------");
        print(prev);
    }
	
	void print(ListNode head)
	{
		System.out.println();
		while(head != null)
		{
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}
	
	
}
