package oop;

import java.util.ArrayList;
import java.util.List;

public class MainClassOOP
{
	public static void main(String[] args)
	{
		CallByConcepts c1 = new CallByConcepts(1);
		CallByConcepts c2 = new CallByConcepts(5);

		System.out.println("c1 : " + c1.a + " | c2: " + c2.a);
		swap(c1, c2);
		System.out.println("c1 : " + c1.a + " | c2: " + c2.a);

		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		method(list);
		System.out.println(list);

	}

	public static void method(List<String> lst)
	{
		lst.add("Three");
	}

	public static void swap(CallByConcepts arg1, CallByConcepts arg2)
	{
		arg1.a = 11;

		CallByConcepts temp = arg1;
		arg1 = arg2;
		arg2 = temp;
	}
}
