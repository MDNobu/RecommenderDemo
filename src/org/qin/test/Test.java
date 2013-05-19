package org.qin.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Double> dbs =  new ArrayList<Double>(50);
		for(Double d : dbs) {
			System.out.print(d);
		}
	}

}
