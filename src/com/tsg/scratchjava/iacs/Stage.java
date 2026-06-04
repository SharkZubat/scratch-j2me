package com.tsg.scratchjava.iacs;

import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.tsg.scratchjava.acs.Sprite;
import com.tsg.scratchjava.iacs.*;
import com.tsg.scratchjava.sys.ImageUtil;
import com.tsg.scratchjava.sys.Point;
import com.tsg.scratchjava.sys.Position;
import com.tsg.scratchjava.sys.SysRuntime;

public class Stage {
	public Image drawnstage;
	public Image view;
	public Vector sprites = new Vector();
	public Vector costumes = new Vector();
	public int currcostume = 0;
	private Hashtable cache = new Hashtable();
	
	public Stage() {
		drawnstage = Image.createImage(480, 360);
		view = Image.createImage(480, 360);
		newProject();
	}
	
	public void render(Point size1) {
		Graphics g = view.getGraphics();
		
		if (size1 != null) {
			if (view.getWidth() != size1.getX() &&
					view.getHeight() != size1.getY()) {
				drawnstage = ImageUtil.resizeImage(drawnstage, (int)size1.getX(), (int)size1.getY());
				view = ImageUtil.resizeImage(view, (int)size1.getX(), (int)size1.getY());
			}
		} else {
			size1 = new Point(view.getWidth(), view.getHeight());
		}
		//g.drawImage((Image) costumes.elementAt(currcostume), 0, 0, 0);
		g.drawImage(drawnstage, 0, 0, 0);
		g.setColor(0xff0000);
		for (int i = 0; i < sprites.size(); i++) {
			Point calc = new Point(((Sprite) sprites.elementAt(i)).pos.x+(size1.getX()/2), (-((Sprite) sprites.elementAt(i)).pos.y)+(size1.getY()/2));
			Image image = ((Sprite) sprites.elementAt(i)).getImage();
			image = ImageUtil.resizeImage(image, (int)(image.getWidth()*(size1.getX()/480f)), (int)((image.getHeight()*(size1.getY()/360f))));
			
			try {
			g.drawImage(image,
					(int)(calc.getX()+(image.getWidth()/-2)),
					(int)(calc.getY()+(image.getHeight()/-2)), 0);
			} catch (NullPointerException e) {
				System.out.println("catched null pointer");
				g.fillRect((int)calc.getX(), (int)calc.getY(), 10, 10);
			}
		}
	}
	
	public void newProject() {
		sprites = new Vector();
		sprites.addElement(new Sprite("Sprite1", new Costume[]{Costume.load("/res/img/c/intl/cat/costume-a.png"), Costume.load("/res/img/c/intl/cat/costume-b.png")}, new Position(0f, 0f, 90)));
	}
}
