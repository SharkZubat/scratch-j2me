package com.tsg.scratchjava.iacs;

import java.util.Vector;

import com.tsg.scratchjava.acs.Sprite;
import com.tsg.scratchjava.iacs.*;

public class Stage {
	public Vector sprites = new Vector();
	public Vector costumes = new Vector();
	
	public void newProject() {
		sprites = new Vector();
		sprites.addElement(new Sprite("Sprite1", Costume.load("/intl/cat/costume-a.bmp")));
	}
}
