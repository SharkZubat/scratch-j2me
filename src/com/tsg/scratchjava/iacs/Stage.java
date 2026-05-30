package com.tsg.scratchjava.iacs;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.tsg.scratchjava.acs.Sprite;
import com.tsg.scratchjava.iacs.*;
import com.tsg.scratchjava.sys.Point;
import com.tsg.scratchjava.sys.Position;

public class Stage {
	public Image drawnstage;
	public Image view;
	public Vector sprites = new Vector();
	public Vector costumes = new Vector();
	public int currcostume = 0;
	
	public Stage() {
		drawnstage = Image.createImage(480, 360);
		view = Image.createImage(480, 360);
		newProject();
	}
	
	public void render() {
		Graphics g = view.getGraphics();
		
		//g.drawImage((Image) costumes.elementAt(currcostume), 0, 0, 0);
		g.drawImage(drawnstage, 0, 0, 0);
		g.setColor(0xff0000);
		for (int i = 0; i < sprites.size(); i++) {
			Point calc = new Point(((Sprite) sprites.elementAt(i)).pos.x+240, (-((Sprite) sprites.elementAt(i)).pos.y)+180);
			Image image = ((Costume) ((Sprite) sprites.elementAt(i)).costumes.elementAt(((Sprite) sprites.elementAt(i)).currcostume)).getImage();
			g.fillRect((int)calc.getX(), (int)calc.getY(), 10, 10);
			try {
			g.drawImage(image,
					(int)calc.getX()+(image.getWidth()/-2),
					(int)calc.getY()+(image.getHeight()/-2), 0);
			} catch (NullPointerException e) {
				System.out.println("catched null pointer");
			}
		}
	}
	
	public void newProject() {
		sprites = new Vector();
		sprites.addElement(new Sprite("Sprite1", new Costume[]{Costume.load("/res/img/c/intl/cat/costume-a.png"), Costume.load("/res/img/c/intl/cat/costume-b.png")}, new Position(0f, 0f, 90)));
	}
}
