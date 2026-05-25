package com.tsg.scratchjava.sys;

public class Position {

	private float x;
	private float y;
	private float d;

	public Position(float x, float y, float d) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.d = d;
	}
	
	public void changePos(float x, float y, float d) {
		this.x += x;
		this.y += y;
		this.d += d;
		updateDir();
	}
	
	private void updateDir() {
		d = ((d-180)%360)+180;
	}
}
