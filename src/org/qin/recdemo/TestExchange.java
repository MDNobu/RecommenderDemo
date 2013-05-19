package org.qin.recdemo;

class IntExchange {
	int value;

	public IntExchange(int i) {
		value = i;
	}

}

public class TestExchange {
	public static void exchange(IntExchange e, IntExchange f) {

		int temp;

		temp = e.value;

		e.value = f.value;

		f.value = temp;
	}

	public static void main(String[] args) {

		IntExchange e = new IntExchange(5);

		IntExchange f = new IntExchange(7);

		exchange(e, f);

		System.out.println(e.value);

		System.out.println(f.value);
	}

}
