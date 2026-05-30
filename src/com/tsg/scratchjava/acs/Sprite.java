package com.tsg.scratchjava.acs;

import java.util.Vector;

import javax.microedition.lcdui.Image;

import com.tsg.scratchjava.iacs.Costume;
import com.tsg.scratchjava.sys.Position;

public class Sprite {
	public Position pos = new Position(0f, 0f, 90);
	public String name = "Sprite";
	public String[] sprites = new String[]{
		"/res/img/spr/cat-a.png",
		"/res/img/spr/cat-b.png"
	};
	public Vector code = new Vector();
	
	public Sprite(String string, Costume costume) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
}
