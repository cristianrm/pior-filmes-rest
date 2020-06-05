package com.filme.rest.service;



import java.util.Comparator;
import java.util.Map;

public class ComparatorInst implements Comparator<String> {

	Map<String, String> base;

	public ComparatorInst(Map<String, String> base) {
		super();
		this.base = base;
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return base.get(o1).compareTo(base.get(o2));
	}

}
