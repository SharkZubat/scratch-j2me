package com.tsg.scratchjava.blocks;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

import com.tsg.scratchjava.sys.ColorUtil;
import com.tsg.scratchjava.sys.Point;


public class BlockRenderer {
	Font font = Font.getDefaultFont();
	private float size = (font.getHeight())/15;
	private int space = (int) (8*size);
	private int jigsawspace = (int) (8*size);
	private int corners = (int) (3*size);
	private boolean light = true;
	public void renderblock(int type, String label, Point point, int color, Graphics g) {
		g.setColor(color);
		/* TOP CORNERS */
		g.fillTriangle((int)point.getX(),(int)point.getY()+corners,
				(int)point.getX()+corners, (int)point.getY(),
				(int)point.getX()+corners, (int)point.getY()+corners);
		g.fillTriangle((int)point.getX()+corners+space,(int)point.getY(),
				(int)point.getX()+(corners*2)+space, (int)point.getY()+corners,
				(int)point.getX()+corners+space, (int)point.getY()+corners);
		g.fillTriangle((int)point.getX()+corners+space+jigsawspace,(int)point.getY()+corners,
				(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY(),
				(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY()+corners);
		g.fillTriangle((int)point.getX()+(corners*3)+font.stringWidth(label), (int)point.getY(),
				(int)point.getX()+(corners*4)+font.stringWidth(label), (int)point.getY()+corners,
				(int)point.getX()+(corners*3)+font.stringWidth(label), (int)point.getY()+corners);
		/* BOTTOM CORNERS */
		g.fillTriangle((int)point.getX(),(int)point.getY()+font.getHeight(),
				(int)point.getX()+corners, (int)point.getY()+corners+font.getHeight(),
				(int)point.getX()+corners, (int)point.getY()+font.getHeight());
		g.fillTriangle((int)point.getX()+corners+space,(int)point.getY()+corners+font.getHeight(),
				(int)point.getX()+(corners*2)+space, (int)point.getY()+(corners*2)+font.getHeight(),
				(int)point.getX()+(corners*2)+space, (int)point.getY()+corners+font.getHeight());
		g.fillTriangle((int)point.getX()+2+space+jigsawspace,(int)point.getY()+corners+font.getHeight(),
				(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY()+corners+font.getHeight(),
				(int)point.getX()+corners+space+jigsawspace, (int)point.getY()+(corners*2)+font.getHeight());
		g.fillTriangle((int)point.getX()+(corners*3)+font.stringWidth(label),(int)point.getY()+font.getHeight(),
				(int)point.getX()+(corners*4)+font.stringWidth(label), (int)point.getY()+font.getHeight(),
				(int)point.getX()+(corners*3)+font.stringWidth(label), (int)point.getY()+corners+font.getHeight());
		/* BODY */
		g.fillRect((int)point.getX(), (int)point.getY()+corners, (corners*4)+font.stringWidth(label), font.getHeight()-corners);
		/* TOP BORDERS */
		g.fillRect((int)point.getX()+corners, (int)point.getY(), space, corners);
		g.fillRect((int)point.getX()+space+jigsawspace+(corners*2), (int)point.getY(), font.stringWidth(label)-space-jigsawspace+corners, corners);
		/* BOTTOM BORDERS */
		g.fillRect((int)point.getX()+corners, (int)point.getY()+font.getHeight(), font.stringWidth(label)+(corners*2), corners);
		g.fillRect((int)point.getX()+space+(corners*2), (int)point.getY()+font.getHeight()+corners, jigsawspace-corners, corners);
		g.setColor(0xffffff);
		g.drawString(label, (int)point.getX()+(corners*2), (int)point.getY()+corners, 0);
		
		if (light) {
			/* LIGHT */
			g.setColor(ColorUtil.colorLerp(color, 0xffffff));
			g.drawLine((int)point.getX(), (int)point.getY()+font.getHeight()-corners,
					(int)point.getX(), (int)point.getY()+corners);
			g.drawLine((int)point.getX(), (int)point.getY()+corners,
					(int)point.getX()+corners, (int)point.getY());
			g.drawLine((int)point.getX()+corners, (int)point.getY(),
					(int)point.getX()+corners+space, (int)point.getY());
			g.drawLine((int)point.getX()+corners+space+jigsawspace, (int)point.getY()+corners,
					(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY());
			g.drawLine((int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY(),
					(int)point.getX()+(corners*2)+font.stringWidth(label), (int)point.getY());
			/* SHADOW */
			g.setColor(ColorUtil.colorLerp(color, ColorUtil.colorLerp(color, 0)));
			g.drawLine((int)point.getX()+corners, (int)point.getY()+font.getHeight()+corners-1,
					(int)point.getX()+corners+space-1, (int)point.getY()+font.getHeight()+corners-1);
			g.drawLine((int)point.getX()+corners+space-1, (int)point.getY()+font.getHeight()+corners-1,
					(int)point.getX()+(corners*2)+space-1, (int)point.getY()+font.getHeight()+(corners*2)-1);
			g.drawLine((int)point.getX()+(corners*2)+space-1, (int)point.getY()+font.getHeight()+(corners*2)-1,
					(int)point.getX()+corners+space+jigsawspace-1, (int)point.getY()+font.getHeight()+(corners*2)-1);
			g.drawLine((int)point.getX()+corners+space+jigsawspace-1, (int)point.getY()+font.getHeight()+(corners*2)-1,
					(int)point.getX()+corners+space+jigsawspace-1, (int)point.getY()+font.getHeight()+(corners*2)-1);
		}
	}
}
