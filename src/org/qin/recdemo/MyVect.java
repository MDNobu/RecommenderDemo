package org.qin.recdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyVect implements Distancable<MyVect>{

	
	List<Double> vect = null;
	private static Dictionary dict = Dictionary.getDict();
	
	public MyVect() {
		vect = new ArrayList<Double>(Collections.nCopies(dict.getLength(), 0d));
	}

	@Override
	public double getDistance(MyVect second) {
		return this.multiply(second) / (this.getLength() * second.getLength());	
	}
	
	public double multiply(MyVect other) {
		List<Double> otherVect = other.vect;
		if(vect.size() != otherVect.size()) {
			throw new RuntimeException("two vector demisions donot match");
		}
		
		double result = 0;
		for(int i = 0; i < vect.size(); i++) {
			result += vect.get(i) * otherVect.get(i);
		}
		return result;
	}
	
	public double getLength() {
		double res = 0;
		for(Double ele : vect) {
			res += Math.pow(ele, 2);
		}
		res = Math.sqrt(res);
		return res;
	}
	
	public Double get(int index) {
		return vect.get(index);
	}
	
	public void set(int index, Double e) {
		vect.set(index, e);
	}
	
	public void print() {
		for(Double num : vect) {
			if(num != 0d){
				System.out.print(num + " ");
			}
		}
	}
	

	public MyVect add(MyVect other) {
		List<Double> otherVect = other.vect;
		if(vect.size() != otherVect.size()) {
			throw new RuntimeException("two vector demisions donot match");
		}
		for(int i = 0; i < vect.size(); i++) {
			double tmp = vect.get(i) + other.vect.get(i);
			vect.set(i, tmp);
		}
		return this;
	}
}
