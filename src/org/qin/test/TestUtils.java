package org.qin.test;

import java.util.List;

public class TestUtils {
	
	
	public  static <E extends Printable>  void printList(Iterable<E> list) {
		for(E e : list) {
			e.print();
		}	
		System.out.println();

	}
}
