package com.tsg.scratchjava.sys;

public class Array {
	private Object[] VALUE = new Object[0];
	public void add(Object args) {
		VALUE[VALUE.length] = args;
	}
	
	public void delete(int idx) {
		VALUE[idx] = null;
		for (int i = idx+1; i < VALUE.length; i++) {
			VALUE[i] = VALUE[i-1];
		}
	}
	
}
