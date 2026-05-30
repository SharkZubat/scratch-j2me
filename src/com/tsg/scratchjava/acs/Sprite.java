package com.tsg.scratchjava.acs;

import java.util.Vector;

import javax.microedition.lcdui.Image;

import com.tsg.scratchjava.iacs.Costume;
import com.tsg.scratchjava.sys.Position;

public class Sprite {
	public Position pos = new Position(0f, 0f, 90);
	public String name = "Sprite";
	public Vector costumes = new Vector();
	public int currcostume = 0;
	public Vector code = new Vector();
	
	public Sprite(String string, Costume[] costume, Position point) {
		// TODO Auto-generated constructor stub
		System.out.println("adding name " + string);
		name = string;
		System.out.println("lenght costume: "+ costume.length);
		for (int i = 0; i < costume.length; i++) {
			System.out.println("adding costume no" + i);
			costumes.addElement(costume[i]);
		}
		pos = point;
	}

	public String getName() {
		return name;
	}

	public Position getPos() {
		// TODO Auto-generated method stub
		return pos;
	}

	public Vector getCostumes() {
		// TODO Auto-generated method stub
		return costumes;
	}
	
	public int getCostumeIdx() {
		return currcostume;
	}
}
